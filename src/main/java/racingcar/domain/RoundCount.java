package racingcar.domain;

public class RoundCount {

    private static final String INVALID_ROUND_NUMBER_ERROR = "시도할 회수는 0이상의 정수여야 합니다.";

    private int roundCount;

    public RoundCount(String roundCount) {
        validate(roundCount);
        this.roundCount = Integer.parseInt(roundCount);
    }

    public void validate(String target) {
        validateType(target);
    }

    public void consumeRound() {
        roundCount--;
    }

    public boolean hasNextRound() {
        if (roundCount == 0) {
            return false;
        }
        return true;
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
