package racingcar.model;

public class CarPosition {
    private int position;

    public CarPosition(final int position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    public boolean isEqualTo(final int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }
}
