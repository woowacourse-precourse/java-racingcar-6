package domain;

import constant.ExceptionMessage;

public class RemainingRound {
    private int round;

    public void set(int round) {
        validateRound(round);
        this.round = round;
    }

    private void validateRound(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_NUMBER_INPUT.getMessage());
        }
    }

    public void playRound() {
        round--;
    }

    public boolean isEnd() {
        return round <= 0;
    }
}
