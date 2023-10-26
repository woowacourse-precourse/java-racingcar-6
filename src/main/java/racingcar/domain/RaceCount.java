package racingcar.domain;

import java.util.Objects;

public class RaceCount {
    private static final int MIN_RACE_COUNT = 1;

    private int raceCount;

    public RaceCount(int raceCount) {
        validateRaceCount(raceCount);
        this.raceCount = raceCount;
    }

    private void validateRaceCount(int raceCount) {
        if (raceCount < MIN_RACE_COUNT) {
            throw new IllegalArgumentException(
                    String.format("경주를 진행할 횟수는 최소 %d이상이어야 합니다.", MIN_RACE_COUNT)
            );
        }
    }

    public void decrease() {
        raceCount--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceCount raceCount1 = (RaceCount) o;
        return raceCount == raceCount1.raceCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceCount);
    }
}
