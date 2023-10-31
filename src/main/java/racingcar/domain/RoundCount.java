package racingcar.domain;

public class RoundCount {

    private static final String INVALID_ROUND_NUMBER_ERROR = "시도할 회수는 0이상의 정수여야 합니다.";

    private int value;

    public RoundCount(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    public void validate(String target) {
        validateType(target);
    }

    public void consumeRound() {
        value--;
    }

    public boolean hasNextRound() {
        return value > 0;
    }

    private void validateType(String target) {
        if (isInvalidType(target)) {
            throw new IllegalArgumentException(INVALID_ROUND_NUMBER_ERROR);
        }
    }

    private static boolean isInvalidType(String target) {
        try {
            Integer.parseInt(target);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
