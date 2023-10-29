package racingcar.util.validator;

import java.util.regex.Pattern;

import racingcar.util.message.ErrorMessage;

public class Validator {

	private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
	private static final int LENGTH = 5;
	
	public static void validateOutOfLength(String carNames) {
		String[] carNameArr = carNames.split(",");
		
		for(String carName : carNameArr) {
			if (carName.length() > LENGTH) {
				throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
			}
		}
	}
	
	public static void validateContainNumber(String carName) {
		if (carName.matches(".*[0-9].*")) {
			throw new IllegalArgumentException(ErrorMessage.CONTAIN_NUMBER_ERROR.getMessage());
		}
	}
	
	public static void validateNumberFormat(String inputValue) {
		if (!NUMBER_PATTERN.matcher(inputValue).matches()) {
			throw new IllegalArgumentException(ErrorMessage.INPUT_LETTER_ERROR.getMessage());
		}
	}
}
