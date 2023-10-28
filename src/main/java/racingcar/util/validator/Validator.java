package racingcar.util.validator;

import racingcar.util.message.ErrorMessage;

public class Validator {

	private static final int LENGTH = 5;

	public static void validateOutOfLength(String carName) {
		if (carName.length() > LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
		}
	}
	
	public static void validateContainNumber(String carName) {
		if (carName.matches(".*[0-9].*")) {
			throw new IllegalArgumentException(ErrorMessage.CONTAIN_NUMBER_ERROR.getMessage());
		}
	}
}
