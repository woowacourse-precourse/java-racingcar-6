package racingcar.validator;

import racingcar.constant.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String NUMBER_REGEXP = "^\\d*$";

    public void validateIsNumber(String input) {
        if (!Pattern.matches(NUMBER_REGEXP, input)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_INTEGER;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }
}
