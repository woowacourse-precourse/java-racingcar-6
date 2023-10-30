package racingcar.domain;

public class CarPosition {
    private static final int MINIMUM_VALUE = 0;

    private final int value;

    private CarPosition(int value) {
        this.value = value;
    }

    public static CarPosition zero() {
        return new CarPosition(MINIMUM_VALUE);
    }

    public static CarPosition from(int value) {
        validateValue(value);
        return new CarPosition(value);
    }

    private static void validateValue(int value) {
        if (value < MINIMUM_VALUE) {
            throw new IllegalArgumentException("자동차의 위치는 양수여야 합니다. 주어진 값은 " + value + " 입니다.");
        }
    }

    public int value() {
        return value;
    }
}
