package racingcar.validator;

public class RacingRoundCountValidator {

    private static final int ROUND_COUNT_MAX_INT_VALUE = 2_147_483_647; // RoundCount 최대 개수
    private static final int ROUND_COUNT_MIN_INT_VALUE = 1; // RoundCount 최소 개수

    private static final String ERROR = "[ERROR] ";
    private static final String ERROR_BLANK = ERROR + "입력값은 공백일 수 없습니다.";
    private static final String ERROR_NON_NUMERIC = ERROR + "숫자를 입력해 주세요." + "입력 값은 1부터 "  + ROUND_COUNT_MAX_INT_VALUE + "까지 입니다.";
    private static final String ERROR_NON_ZERO = ERROR + "1 이상인 양수를 입력해 주세요.";

    private RacingRoundCountValidator() {}

    public static void validate(final String input) {
        validateBlankException(input);
        validateNumericException(input);
        validatePositiveNumber(input);
    }

    private static void validateBlankException(final String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private static void validateNumericException(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC);
        }
    }

    private static void validatePositiveNumber(final String input) {
        int number = Integer.parseInt(input);
        if (number < ROUND_COUNT_MIN_INT_VALUE) {
            throw new IllegalArgumentException(ERROR_NON_ZERO);
        }
    }
}
