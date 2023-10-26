package model;

public class MovingCount {
    private int movingCount;

    public MovingCount() {
        this.movingCount = 0;
    }

    public void increase() {
        this.movingCount++;
    }

    public int getMovingCount() {
        return this.movingCount;
    }
}
