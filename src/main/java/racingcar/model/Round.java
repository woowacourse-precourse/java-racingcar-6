package racingcar.model;

import racingcar.exception.count.CountRangeException;

public class Round {
    private static final int MINIMUM_COUNT = 0;
    private static final int END = 0;
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

    public boolean isEndRacing() {
        return count == END;
    }
}
