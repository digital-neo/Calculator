package ru.univerge.calculator;

public class Validator {

	static String[] maskArabic = new String[] { "10", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	static String[] maskRoman = new String[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };
	static final int CHAR_NOT_FOUND = -1;

	static boolean validArabic(String sequence) {

		for (String each : maskArabic) {
			if (each.equals(sequence)) {
				return true;
			}
		}

		return false;
	}

	static boolean validRoman(String sequence) {
		for (String each : maskRoman) {
			if (each.equals(sequence)) {
				return true;
			}
		}

		return false;
	}
}
