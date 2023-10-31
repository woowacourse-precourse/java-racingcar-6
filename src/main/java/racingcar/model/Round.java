package racingcar.model;

import racingcar.exception.count.CountRangeException;
import racingcar.exception.count.NoRemainingRoundsException;

public class Round {
    private static final int MINIMUM_COUNT = 0;
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
        checkRemainingRounds();
        count--;
    }

    private void checkRemainingRounds() {
        if (count <= MINIMUM_COUNT) {
            throw new NoRemainingRoundsException();
        }
    }

    public boolean isNotZero() {
        return count != MINIMUM_COUNT;
    }
}