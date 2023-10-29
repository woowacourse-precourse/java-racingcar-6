package racingcar.view;

import racingcar.constant.ExceptionMessage;

public class InputValidator {

    private static final String DELIMITER = ",";
    private static final String NUMBER_REGEX = "^[0-9]+$";

    public void validateDelimiter(String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_HAVE_DELIMITER.getMessage());
        }
    }

    public void validateNumber(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_AVAILABLE_STRING.getMessage());
        }
    }
}
