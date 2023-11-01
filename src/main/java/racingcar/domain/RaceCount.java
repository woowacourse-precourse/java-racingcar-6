package racingcar.domain;

import racingcar.common.exception.CustomErrorException;
import racingcar.common.response.ErrorCode;

public class RaceCount {

    private static final int MIN_COUNT_RANGE = 1;
    private static final int RACE_END_COUNT = 0;

    private int count;

    public RaceCount(int count) {
        validateCount(count);
        this.count = count;
    }

    public void reduceCount() {
        count--;
    }

    public boolean isEnd() {
        return count == RACE_END_COUNT;
    }

    private void validateCount(int count) {
        if(isInvalidRange(count)) {
            throw new CustomErrorException(ErrorCode.RACE_COUNT_INVALID_RANGE);
        }
    }

    private boolean isInvalidRange(int count) {
        return count < MIN_COUNT_RANGE;
    }
}
