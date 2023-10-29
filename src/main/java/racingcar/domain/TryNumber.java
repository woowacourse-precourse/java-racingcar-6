package racingcar.domain;

import static racingcar.error.Error.INVALID_NUMBER;
import static racingcar.error.Error.NUMBER_POSITIVE_ERROR;

public class TryNumber {
	private final Integer tryNumber;

	public TryNumber(String input) {
		validateNumber(input);
		this.tryNumber = Integer.parseInt(input);
	}

	private void validateNumber(String input) {
		if (!isNumeric(input)) {
			throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
		}
		if (!isPositive(input)) {
			throw new IllegalArgumentException(NUMBER_POSITIVE_ERROR.getMessage());
		}
	}

	private boolean isNumeric(String input) {
		return input.matches("[0-9]+");
	}

	private boolean isPositive(String input) {
		return Integer.parseInt(input) > 0;
	}
}
