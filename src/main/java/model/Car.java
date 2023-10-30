package model;

public class Car implements Comparable<Car> {

    private final Name name;
    private final MovingCount movingCount;
    private static final String DASH = "-";
    private static final String STATUS_SEPARATOR = " : ";

    public Car(String name) {
        this.name = new Name(name);
        this.movingCount = new MovingCount();
    }

    public void increaseMovingCountIfGreater(int standardNumber, int randomNumber) {
        if (randomNumber > standardNumber) {
            this.movingCount.increase();
        }
    }

    public int getMovingCount() {
        return this.movingCount.getMovingCount();
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
        MovingCount otherMovingCount = otherCar.movingCount;
        return otherMovingCount.getMovingCount() - this.getMovingCount();
    }

    @Override
    public String toString() {
        return this.name.getName();
    }
}
