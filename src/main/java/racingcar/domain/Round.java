package racingcar.domain;

public class Round {
    public final int round;
    private static final String INVALID_INPUT_IS_EMPTY = "입력값이 공백입니다.";
    private final static String INVALID_INPUT_TYPE = "숫자가 아닌 값이 포함되어있습니다.";

    public Round(String input) {
        validateInputNotEmpty(input);
        validateInteger(input);
        this.round = Integer.parseInt(input);
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
}
