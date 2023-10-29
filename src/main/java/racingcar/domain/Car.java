package racingcar.domain;

public class Car implements Comparable<Car> {
    private String name;
    private int movedCount;

    Driver driver = new Driver();

    public Car(String name) {
        this.name = name;
        this.movedCount = 0;
    }

    public void move() {
        if (canGo()) {
            this.movedCount++;
        }
    }

    public boolean canGo() {
        int strength = driver.pressAccelerator();
        if (strength >= 4) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.movedCount - otherCar.movedCount;
    }

    public boolean isSamePosition(Car otherCar) {
        return this.movedCount == otherCar.movedCount;
    }

    public String getName() {
        return name;
    }
}
