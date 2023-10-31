package racingcar.model;

public class CarMoved {
    private int moved;

    public CarMoved(int moved) {
        this.moved = moved;
    }

    public int getMoved() {
        return moved;
    }

    public void increase() {
        if (moved < Integer.MAX_VALUE) {
            moved++;
        }
    }
}
