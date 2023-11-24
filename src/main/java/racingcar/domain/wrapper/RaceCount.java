package racingcar.domain.wrapper;

import racingcar.domain.constant.RaceConstant;

import static racingcar.util.message.ExceptionMessage.*;

public class RaceCount {
    private final int count;

    private RaceCount(final String raceCount) {
        validateNameBlank(raceCount);
        int count = validateType(raceCount);
        this.count = validateRange(count);
    }

    public static RaceCount create(final String raceCount) {
        return new RaceCount(raceCount);
    }

    private void validateNameBlank(final String raceCount) {
        if (raceCount.isBlank()) {
            throw new IllegalArgumentException(String.format(BLANK_MESSAGE.getValue(), "시도횟수"));
        }
    }

    private int validateType(final String raceCount) {
        int count;
        try {
            count = Integer.parseInt(raceCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(TYPE_MESSAGE.getValue(), "시도 횟수"));
        }
        return count;
    }

    private int validateRange(final int raceCount) {
        if (raceCount <= RaceConstant.RACE_MIN_TRY_COUNT.getValue()) {
            throw new IllegalArgumentException(String.format(RANGE_MESSAGE.getValue(), RaceConstant.RACE_MIN_TRY_COUNT.getValue()));
        }
        return raceCount;
    }

    public int getCount() {
        return count;
    }
}
