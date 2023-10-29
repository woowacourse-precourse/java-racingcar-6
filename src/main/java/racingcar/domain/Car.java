package racingcar.domain;

public class Car implements Comparable<Car> {
    private String name;
    private int movedCount;

    Accelerator accelerator = new Accelerator();

    public Car(String name) {
        this.name = name;
        this.movedCount = 0;
    }

    public void move() {
        if (accelerator.press()) {
            movedCount++;
        }
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
