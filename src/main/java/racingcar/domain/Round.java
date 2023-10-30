package racingcar.domain;

public class Round {
    public final int round;
    private static final String INVALID_INPUT_IS_EMPTY = "입력값이 공백입니다.";
    private final static String INVALID_INPUT_TYPE = "숫자가 아닌 값이 포함되어있습니다.";
    private final static String INVALID_INPUT_RANGE = "입력값은 자연수입니다.";
    private final static int MIN_RANGE = 1;

    public Round(String input) {
        validateInputNotEmpty(input);
        validateInteger(input);
        int roundNumber = Integer.parseInt(input);
        validateInputRange(roundNumber);
        this.round = roundNumber;
    }

    private void validateInputNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_IS_EMPTY);
        }
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE);
        }
    }

    private static void validateInputRange(int round) {
        if (round < MIN_RANGE) {
            throw new IllegalArgumentException(INVALID_INPUT_RANGE);
        }
    }
}
