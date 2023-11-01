package racingcar.utils.validator;

import racingcar.utils.message.ErrorMessage;

public class InputValidator {
    private static final String INPUT_NAMES_PATTERN = "^[a-zA-Z가-힣]+(,[a-zA-Z가-힣]+)*$";
    private static final int MINIMUM_ROUND_RANGE = 1;
    private static final int MAXIMUM_ROUND_RANGE = 10;

    private InputValidator() {}

    public static void validateInputNames(String names) {
        if (isNotNamesPattern(names)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAMES_INPUT.getMessage());
        }
    }

    public static void validateInputRound(String round) {
        validateIsDigit(round);
        validateRoundRange(round);
    }

    private static void validateIsDigit(String round) {
        if (isNotDigit(round)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DIGIT_FORM.getMessage());
        }
    }

    private static void validateRoundRange(String round) {
        if (isNotValidRange(Integer.parseInt(round))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_RANGE_INPUT.getMessage());
        }
    }

    private static boolean isNotNamesPattern(String names) {
        return !names.matches(INPUT_NAMES_PATTERN);
    }

    private static boolean isNotDigit(String round) {
        try {
            Integer.parseInt(round);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private static boolean isNotValidRange(int round) {
        return round < MINIMUM_ROUND_RANGE || MAXIMUM_ROUND_RANGE < round;
    }
}
