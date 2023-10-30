package racingcar.domain;

public class Round {
    public final int round;
    private static final String INVALID_INPUT_IS_EMPTY = "입력값이 공백입니다.";

    public Round(String input) {
        validateInputNotEmpty(input);
        this.round = Integer.parseInt(input);
    }

    private void validateInputNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_IS_EMPTY);
        }
    }
}
