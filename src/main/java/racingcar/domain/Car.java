package racingcar.domain;

public class Car implements Comparable<Car> {
    private final String name;
    private int mileage;

    public Car(String name) {
        this.name = name;
        mileage = 0;
    }

    public void moveForward(int number) {
        if (number >= 4) {
            ++mileage;
        }
    }

    @Override
    public int compareTo(Car car) {
        return this.mileage - car.getMileage();
    }

    public String getName() {
        return name;
    }

    public int getMileage() {
        return mileage;
    }
}
