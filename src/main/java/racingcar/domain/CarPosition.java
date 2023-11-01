package racingcar.domain;

public class CarPosition {

    private int value;

    public CarPosition(final int value) {
        this.value = value;
    }

    public void increase(final int size) {
        value += size;
    }

    public int getValue() {
        return value;
    }

    public boolean isSame(final int compareValue) {
        return value == compareValue;
    }
}
