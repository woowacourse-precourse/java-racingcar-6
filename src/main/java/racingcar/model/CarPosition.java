package racingcar.model;

public class CarPosition {
    private final int INITIAL_POS = 0;
    private int pos;
    private final int DISTANCE = 1;

    public CarPosition() {
        this.pos = INITIAL_POS;
    }

    public void advancePosition() {
        pos += DISTANCE;
    }

    public int toInt() {
        return this.pos;
    }
}
