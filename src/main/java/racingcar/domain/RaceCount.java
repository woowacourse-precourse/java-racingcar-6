package racingcar.domain;

import static racingcar.utils.ErrorMessages.REPEAT_COUNT_NOT_ZERO;

public class RaceCount {
    private int count;

    public RaceCount(int count) {
        validateZero(count);
        this.count = count;
    }

    private void validateZero(int count) {
        if (count == 0) {
            throw new IllegalArgumentException(REPEAT_COUNT_NOT_ZERO);
        }
    }

    public void disCount() {
        count--;
    }

    public Boolean isRunable() {
        return count > 0;
    }
}
