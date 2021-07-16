package ru.univerge.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
	public static void main(String... args) {
		Scanner stdin = new Scanner(System.in);
		String input;
		String mathSymbol;
		String[] arguments;
		InputMismatchException ex = new InputMismatchException();
		int first = 0;
		int second = 1;
		boolean validArabic = false;
		boolean validRoman = false;
		String number1;
		String number2;
		int int1;
		int int2;
		int result = 0;
		String sResult;

		while (!(input = stdin.nextLine()).equals("exit")) {
			mathSymbol = Parser.getMathSymbol(input);

			try {
				if (mathSymbol.equals(new String())) {
					throw ex;
				}

			} catch (Exception e) {
				System.out.println("Ошибка в знаке математической операции");
				System.exit(1);
			}

			arguments = Parser.getArguments(input, mathSymbol);

			if (Validator.validArabic(arguments[first]) && Validator.validArabic(arguments[second])) {
				validArabic = true;
				validRoman = false;
			} else if (Validator.validRoman(arguments[first]) && Validator.validRoman(arguments[second])) {
				validArabic = false;
				validRoman = true;
			} else {
				validArabic = false;
				validRoman = false;
			}

			try {
				if (!validArabic && !validRoman) {
					throw ex;
				}

			} catch (Exception e) {
				System.out.println("Ошибка в операнде(-дах)");
				System.exit(1);
			}

			if (validRoman) {
				number1 = Converter.toArabic(arguments[first]);
				number2 = Converter.toArabic(arguments[second]);
				try {
					if (number1.equals("") || number2.equals("")) {
						throw new Exception();
					}
				} catch (Exception e) {
					System.out.println("Ошибка алгоритма");
					System.exit(1);
				}
			} else {
				number1 = arguments[first];
				number2 = arguments[second];
			}

			int1 = Integer.parseInt(number1);
			int2 = Integer.parseInt(number2);

			switch (mathSymbol) {
			case "+":
				result = int1 + int2;
				break;
			case "-":
				result = int1 - int2;
				break;
			case "*":
				result = int1 * int2;
				break;
			case "/":
				result = int1 / int2; // делаем целочисленное деление, поскольку х.з.
				break; // как это будет выглядеть с римскими дробными цифрами
			default:
				System.out.println("Ошибка алгоритма");
				System.exit(1);
			}

			if (validRoman) {
				sResult = Converter.toRoman(result);
			} else {
				sResult = Integer.toString(result);
			}

			System.out.println(sResult);
		}
	}
}
