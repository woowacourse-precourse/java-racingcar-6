package racingcar.validator;

import racingcar.view.ErrorMessages;

public class CarValidator {

    private static final int CAR_NAME_LENGTH = 5;

    public static void validateNameLength(String input) {
        if (input.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.NAME_LENGTH.getMessage());
        }
    }

    public static void validateNameUsingCommas(String input) {
        if (input.matches(".*[^a-zA-Z0-9,\\s].*")) {
            throw new IllegalArgumentException(ErrorMessages.USING_COMMAS.getMessage());
        }
    }
}
