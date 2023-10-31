package model;

import java.util.Objects;

public class MovingCount {

    private int movingCount;

    public MovingCount(int movingCount) {
        this.movingCount = movingCount;
    }

    public void increase() {
        this.movingCount++;
    }

    public int getMovingCount() {
        return this.movingCount;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof MovingCount otherMovingCount) {
            return this.movingCount == otherMovingCount.movingCount;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.movingCount);
    }
}
