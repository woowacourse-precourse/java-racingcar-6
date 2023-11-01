package racingcar.race;

import racingcar.utils.ErrorMessage;

public class RoundCount {
    private int roundCount;

    public RoundCount(String roundCount) throws IllegalArgumentException {
        validateRoundCount(roundCount);
        this.roundCount = Integer.parseInt(roundCount);
    }

    private void validateRoundCount(String roundCount) throws IllegalArgumentException {
        try {
            int inputNumber = Integer.parseInt(roundCount);
            if (inputNumber < 1) {
                throw new IllegalArgumentException(ErrorMessage.MINIMUM_TRY_NEEDED);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MOVE_COUNT_IS_NOT_NUMBER);
        }
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void decreaseCount() {
        if (isRemained()) {
            roundCount--;
        }
    }

    public boolean isRemained() {
        return roundCount > 0;
    }

    @Override
    public String toString() {
        return "RoundCount{" +
                "roundCount=" + roundCount +
                '}';
    }
}
