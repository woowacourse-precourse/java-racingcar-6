package racingcar.model;

import racingcar.exception.count.CountRangeException;

public class Round {
    private static final int MINIMUM_COUNT = 0;
    private static final int ZERO = 0;
    private int count;

    public Round(int count) {
        validate(count);
        this.count = count;
    }

    private static void validate(int count) {
        if (count <= MINIMUM_COUNT) {
            throw new CountRangeException();
        }
    }

    public void nextRound() {
        count--;
    }

    public boolean isNotZero() {
        return count != ZERO;
    }
}
