package racingcar.domain;

import static racingcar.domain.Constant.MINIMUM_RACE_COUNT;
import static racingcar.domain.ErrorMessage.RACE_COUNT_IS_NOT_IN_RANGE;

import java.util.Objects;

public class RaceCount {

    private int value;

    public RaceCount(final int count) {
        this.value = count;
    }

    public static RaceCount from(final int rawCount) {
        validateRange(rawCount);
        return new RaceCount(rawCount);
    }

    public static RaceCount init() {
        return new RaceCount(0);
    }

    private static void validateRange(final int count) {
        if (!isInRange(count)) {
            throw new IllegalArgumentException(RACE_COUNT_IS_NOT_IN_RANGE);
        }
    }

    private static boolean isInRange(final int count) {
        return count >= MINIMUM_RACE_COUNT;
    }

    public void increase() {
        value++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RaceCount raceCount = (RaceCount) o;
        return value == raceCount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
