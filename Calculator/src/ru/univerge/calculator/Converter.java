package ru.univerge.calculator;

public class Converter {

	static String toArabic(String number) {
		String[] arabic = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		String[] roman = new String[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };

		for (int i = 0; i < roman.length; i++) {
			if (roman[i].equals(number)) {
				return arabic[i];
			}
		}

		return new String();
	}

	static String toRoman(int number) {
		String[] roman = new String[] { "C", "XC", "LXXX", "LXX", "LX", "L", "XL", "XXX", "XX", "X", "IX", "VIII",
				"VII", "VI", "V", "IV", "III", "II", "I" };
		int[] arabic = new int[] { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		String result = new String();
		int aNumber = number;

		for (int i = 0; i < arabic.length; i++) {
			if (aNumber % arabic[i] == 0) {
				result = result + roman[i];
				break;
			} else if ((int) (aNumber / arabic[i]) == 0) {
				continue;
			} else {
				result = result + roman[i];
				aNumber = aNumber % arabic[i];
			}
		}

		if (number == 0) {
			return "0";
		} else if (number < 0) {
			return "-" + result;
		} else {
			return result;
		}
	}
}
