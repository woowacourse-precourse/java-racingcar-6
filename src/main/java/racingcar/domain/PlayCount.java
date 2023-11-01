package racingcar.domain;

import java.util.Objects;

public class PlayCount {
    private static final int PLAY_MINIMUM_VALUE = 1;
    private static final int PLAY_FINISHED_VALUE = 0;

    private final int value;

    private PlayCount(int value) {
        this.value = value;
    }

    public static PlayCount from(int value) {
        if (value < PLAY_MINIMUM_VALUE) {
            throw new IllegalArgumentException("시도 횟수는 " + PLAY_MINIMUM_VALUE + "이상이어야 합니다. 주어진 값은 " + value + "입니다.");
        }
        return new PlayCount(value);
    }

    public PlayCount play() {
        return new PlayCount(value - 1);
    }

    public boolean finished() {
        return value == PLAY_FINISHED_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayCount playCount = (PlayCount) o;
        return value == playCount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
