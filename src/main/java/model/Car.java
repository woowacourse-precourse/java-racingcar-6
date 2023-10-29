package model;

public class Car implements Comparable<Car> {
    private final Name name;
    private final MovingCount movingCount;
    private static final String DASH = "-";
    private static final String COLON = ":";
    private static final String SPACE = " ";

    public Car(String name) {
        this.name = new Name(name);
        this.movingCount = new MovingCount();
    }

    public boolean isSameMovingCount(Car otherCar) {
        return this.movingCount.equals(otherCar.movingCount);
    }

    public void increaseMovingCountIfGreater(int number, int randomNumber) {
        if (randomNumber >= number) {
            this.movingCount.increase();
        }
    }

    public String currentRacingStatus() {
        String moveDash = DASH.repeat(movingCount.getMovingCount());
        return this + SPACE + COLON + SPACE + moveDash;
    }

    @Override
    public int compareTo(Car otherCar) {
        MovingCount otherMovingCount = otherCar.movingCount;
        return otherMovingCount.getMovingCount() - movingCount.getMovingCount();
    }

    @Override
    public String toString() {
        return this.name.getName();
    }
}
