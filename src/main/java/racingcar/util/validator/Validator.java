package racingcar.util.validator;

import java.util.regex.Pattern;

import racingcar.util.message.ErrorMessage;

public class Validator {

	public static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
	
	private Validator() {
		throw new AssertionError();
	}
	
	public static void validateNumberFormat(String inputValue) {
		if (!NUMBER_PATTERN.matcher(inputValue).matches()) {
			throw new IllegalArgumentException(ErrorMessage.INPUT_LETTER_ERROR.getMessage());
		}
	}
	
	public static void validateIsEmpty(String inputValue) {
		if(isStringEmpty(inputValue)) {
			throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY_ERROR.getMessage());
		}
	}
	
	private static boolean isStringEmpty(String str) {
        return str == null || str.isBlank();
    }
}
