package racingcar.validator;

import racingcar.enums.ErrorMessage;
import racingcar.enums.RegexPattern;
import racingcar.util.Convertor;

public class TryCountValidator {
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
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR.getMessage());
        }
    }

    private static void validateInputFormat(String input) {
        if (!RegexPattern.ONLY_NUMBER.matches(input)) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_ONY_NUMBER.getMessage());
        }
    }

    private static void validateInputRange(String input) {
        int tryCount = Convertor.convertStringToInt(input);
        if (tryCount < MIN_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_GT_ZERO.getMessage());
        }
    }

    private static void validateIsStartZero(String input) {
        if (input.charAt(0) == ZERO) {
            Integer.parseInt(input);
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_NOT_ALLOW_ZERO_IN_FIRST.getMessage());
        }
    }
}
