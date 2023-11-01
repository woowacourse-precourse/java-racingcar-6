package racingcar.view;

import racingcar.constant.message.ExceptionMessage;

public class InputValidator {

    private static final String DELIMITER = ",";
    private static final String NUMBER_REGEX = "^[0-9]+$";

    public void validateDelimiter(final String input) {
        if (isOneCar(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_HAVE_DELIMITER.getMessage());
        }
    }

    private static boolean isOneCar(String input) {
        return !input.contains(DELIMITER);
    }

    public void validateNumber(final String input) {
        if (isNotInputNumber(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_AVAILABLE_STRING.getMessage());
        }
    }

    private static boolean isNotInputNumber(String input) {
        return !input.matches(NUMBER_REGEX);
    }
}
