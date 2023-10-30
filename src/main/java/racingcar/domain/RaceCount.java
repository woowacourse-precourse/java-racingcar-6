package racingcar.domain;

import racingcar.common.exception.CustomErrorException;
import racingcar.common.response.ErrorCode;

public record RaceCount(int count) {

    private static final int MIN_COUNT_RANGE = 1;

    public RaceCount {
        validateCount(count);
    }

    private void validateCount(int count) {
        if(isInvalidRange(count)) {
            throw new CustomErrorException(ErrorCode.RACE_COUNT_INVALID_RANGE);
        }
    }

    private static boolean isInvalidRange(int count) {
        return count < MIN_COUNT_RANGE;
    }
}
