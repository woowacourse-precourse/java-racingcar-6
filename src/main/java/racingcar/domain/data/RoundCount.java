package racingcar.domain.data;

import racingcar.constants.Message;

public class RoundCount {
    private final int roundCount;

    public RoundCount(String roundCount) {
        this.roundCount = validateRoundCount(roundCount);
    }

    public int getRoundCount() {
        return roundCount;
    }

    private int validateRoundCount(String roundCount) {
        try {
            int count = Integer.parseInt(roundCount);
            if (count <= 0) {
                throw new IllegalArgumentException(Message.ROUND_COUNT_AT_LEAST_ONE);
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ROUND_COUNT_NOT_NUMBER);
        }
    }
}
