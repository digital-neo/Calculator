package ru.univerge.calculator;

public class Parser {

	final static int CHAR_NOT_FOUND = -1;
	static int position = CHAR_NOT_FOUND;

	static String getMathSymbol(String input) {

		char[] mathSymbols = { '+', '-', '/', '*' };
		int found = 0;
		String mathSymbol = new String();

		for (int i = 0; i < mathSymbols.length; i++) {

			position = input.indexOf(mathSymbols[i]);

			if (position == CHAR_NOT_FOUND) {
				continue;
			} else {
				found++;
				if (found > 1) {
					break;
				} else {
					mathSymbol = Character.toString(input.charAt(position));
				}
				if (position != input.lastIndexOf(mathSymbols[i])) {
					found++;
					break;
				}
			}
		}

		if (found == 1) {
			return mathSymbol;
		}

		return new String();
	}

	static String[] getArguments(String input, String mathSymbol) {

		String[] errorExitValue = new String[0];
		int first = 0;
		int second = 1;
		String[] arguments;
		String a, b;

		arguments = input.split("[" + mathSymbol + "]");

		if (arguments.length != 2) {
			return errorExitValue;
		}

		a = arguments[first].trim();
		b = arguments[second].trim();

		return new String[] { a, b };
	}
}