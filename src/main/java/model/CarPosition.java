package model;

public class CarPosition {
    private final int INITIAL_POS = 0;
    private int pos;

    public CarPosition() {
        this.pos = INITIAL_POS;
    }

    public void moveByDistance(int distance) {
        pos += distance;
    }

    public int toInt() {
        return this.pos;
    }
}
