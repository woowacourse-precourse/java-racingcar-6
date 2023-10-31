package model;

public class Car implements Comparable<Car> {

    private final Name name;
    private final MovingCount movingCount;
    private static final String DASH = "-";
    private static final String STATUS_SEPARATOR = " : ";

    public Car(Name name, MovingCount movingCount) {
        this.name = name;
        this.movingCount = movingCount;
    }

    public void increaseMovingCountIfGreater(int minimumNumber, int randomNumber) {
        if (randomNumber >= minimumNumber) {
            this.movingCount.increase();
        }
    }

    public boolean isSameMovingCount(Car otherCar) {
        return this.movingCount.equals(otherCar.movingCount);
    }

    public String currentRacingStatus() {
        String dash = DASH.repeat(movingCount.getMovingCount());
        return this + STATUS_SEPARATOR + dash;
    }

    @Override
    public int compareTo(Car otherCar) {
        int otherMovingCount = otherCar.movingCount.getMovingCount();
        int currentMovingCount = this.movingCount.getMovingCount();
        return Integer.compare(otherMovingCount, currentMovingCount);
    }

    @Override
    public String toString() {
        return this.name.getName();
    }
}
