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

}
