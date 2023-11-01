package racingcar.domain;

public class CarPosition {

    private static final int ZERO_POSITION = 0;

    private int position;

    private CarPosition(final int position) {
        validate(position);
        this.position = position;
    }

    public static CarPosition zeroPosition() {
        return new CarPosition(ZERO_POSITION);
    }

    public static CarPosition from(final int position) {
        return new CarPosition(position);
    }

    private void validate(final int position) {
        if (position < ZERO_POSITION) {
            throw new IllegalArgumentException("자동차 위치는 0보다 크거나 같아야 합니다.");
        }
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
