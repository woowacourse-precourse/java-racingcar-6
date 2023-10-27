package racingcar.validator;

import racingcar.util.Convertor;

public class TryCountValidator {
    private static final String ONLY_NUMBER = "^[0-9]*$";
    private static final char ZERO = '0';
    private static final int MIN_COUNT = 1;

    private TryCountValidator() {
    }

    public static void validate(String input) {
        validateNull(input);
        validateInputFormat(input);
        validateInputRange(input);
        validateIsStartZero(input);
    }

    private static void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR);
        }
    }

    private static void validateInputFormat(String input) {
        if (!input.matches(ONLY_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_ONY_NUMBER);
        }
    }

    private static void validateInputRange(String input) {
        int tryCount = Convertor.convertStringToInt(input);
        if (tryCount < MIN_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_GT_ZERO);
        }
    }

    private static void validateIsStartZero(String input) {
        if (input.charAt(0) == ZERO) {
            Integer.parseInt(input);
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_NOT_ALLOW_ZERO_IN_FIRST);
        }
    }
}
