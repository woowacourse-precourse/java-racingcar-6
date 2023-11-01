package racingcar.util;

public class PlayRound {
    private static final String NUMBER_PATTERN = "[0-9]+";
    private static final String EXCEPTION_MESSAGE = "유효하지않은 입력입니다.";

    private final String value;

    public PlayRound(String value) {
        validateInputRange(value);
        this.value = value;
    }

    public Integer extractPlayRound() {
        return Integer.valueOf(this.value);
    }

    private void validateInputRange(final String playRounds) {
        if (playRounds.equals("0") || !playRounds.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}
