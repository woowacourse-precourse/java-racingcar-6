package racingcar.model;

import racingcar.exception.ErrorException;

public class Round {
    private static final int ZERO = 0;
    private final int round;

    public Round(int round) {
        validate(round);
        this.round = round;
    }

    private void validate(int round) {
        if (round > Integer.MAX_VALUE || round <= ZERO) {
            throw new IllegalArgumentException(ErrorException.OUT_OF_RANGE.getErrorDescription());
        }
    }

    public int getRound() {
        return round;
    }

}
