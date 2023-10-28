package racingcar.validator;

import racingcar.constant.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String NUMBER_REGEXP = "^\\d*$";
    private static final String DELIMITER_REGEXP = "^[a-zA-Zㄱ-힣0-9,]*$";

    public void validateIsNumber(String input) {
        if (!Pattern.matches(NUMBER_REGEXP, input)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_INTEGER;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }

    public void validateDelimiter(String input) {
        if (!Pattern.matches(DELIMITER_REGEXP, input)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INCORRECT_DELIMITER;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }
}
