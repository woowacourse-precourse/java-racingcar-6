package racingcar.model;

public class CarPosition {
    private int position;

    public CarPosition(final int position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
