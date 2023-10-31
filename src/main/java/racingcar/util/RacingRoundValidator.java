package racingcar.util;

public class RacingRoundValidator {
    private static final String INVALID_INPUT_IS_EMPTY = "입력값이 공백입니다.";
    private static final String INVALID_INPUT_TYPE = "숫자가 아닌 값이 포함되어있습니다.";
    private static final String INVALID_INPUT_RANGE = "입력값은 자연수입니다.";
    private static final int MIN_RANGE = 1;

    private RacingRoundValidator() {
    }

    public static void validateInputNotEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_IS_EMPTY);
        }
    }

    public static void validateIsParsableToInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE);
        }
    }

    public static void validateInputRange(int round) {
        if (round < MIN_RANGE) {
            throw new IllegalArgumentException(INVALID_INPUT_RANGE);
        }
    }
}
