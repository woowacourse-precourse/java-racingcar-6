package racingcar.domain;

import static racingcar.error.Error.*;

public class NumberValidator {
	public static void validate(String input) {
		if (!isNumeric(input)) {
			throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
		}
		if (!isPositive(input)) {
			throw new IllegalArgumentException(NUMBER_POSITIVE_ERROR.getMessage());
		}
	}

	private static boolean isNumeric(String input) {
		return input.matches("[0-9]+");
	}

	private static boolean isPositive(String input) {
		return Integer.parseInt(input) > 0;
	}
}
