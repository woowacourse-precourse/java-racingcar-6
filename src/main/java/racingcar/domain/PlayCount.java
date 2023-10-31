package racingcar.domain;

public class PlayCount {
    private static final int MINIMUM_VALUE = 1;

    private final int value;

    private PlayCount(int value) {
        this.value = value;
    }

    public static PlayCount from(int value) {
        if (value < MINIMUM_VALUE) {
            throw new IllegalArgumentException("시도 횟수는 " + MINIMUM_VALUE + "이상이어야 합니다. 주어진 값은 " + value + "입니다.");
        }
        return new PlayCount(value);
    }
}
