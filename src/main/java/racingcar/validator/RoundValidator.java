package racingcar.validator;

import racingcar.view.ErrorMessages;

public class RoundValidator {

    public static void validateRounds(String input) {
        if (isNotValidPositiveInteger(input)) {
            throw new IllegalArgumentException((ErrorMessages.INVALID_ROUND_COUNT.getMessage()));
        }
    }

    private static boolean isNotValidPositiveInteger(String input) {
        String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";
        return !input.matches(POSITIVE_INTEGER_REGEX);
    }
}
