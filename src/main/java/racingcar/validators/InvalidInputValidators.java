package racingcar.validators;

public class InvalidInputValidators {

	private static final int CAR_NAME_MAX_LENGTH = 5;

	public void validateCarName(String name) {
		if (!isNotBlankOrNull(name) || !isStringOfMaxLength(name)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isNotBlankOrNull(String input) {
		return input != null && !input.isBlank();
	}

	private boolean isStringOfMaxLength(String input) {
		return input.length() <= CAR_NAME_MAX_LENGTH;
	}
}