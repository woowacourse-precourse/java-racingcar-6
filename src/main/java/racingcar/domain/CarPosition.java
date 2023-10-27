package racingcar.domain;

public class CarPosition {

    private static final int INITIAL_POSITION = 0;

    private int position;

    private CarPosition() {
        this.position = INITIAL_POSITION;
    }

    static CarPosition create() {
        return new CarPosition();
    }

    void move() {
        position++;
    }

    int getPosition() {
        return position;
    }
}
