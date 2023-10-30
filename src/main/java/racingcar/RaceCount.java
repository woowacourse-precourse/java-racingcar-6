package racingcar;

import static racingcar.Constant.MINIMUM_RACE_COUNT;
import static racingcar.ErrorMessage.RACE_COUNT_IS_NOT_IN_RANGE;

public class RaceCount {

    private final int value;

    public RaceCount(final int count) {
        this.value = count;
    }

    public static RaceCount from(int rawCount) {
        validateRange(rawCount);
        return new RaceCount(rawCount);
    }

    private static void validateRange(int count) {
        if (!isInRange(count)) {
            throw new IllegalArgumentException(RACE_COUNT_IS_NOT_IN_RANGE);
        }
    }

    private static boolean isInRange(int count) {
        return count >= MINIMUM_RACE_COUNT;
    }

    public boolean isSameCount(int tryCount) {
        return value == tryCount;
    }
}
