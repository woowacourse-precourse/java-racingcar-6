package racingcar.model;

import java.util.Objects;

public class Car {
    public static final int DISTANCE_INIT_VALUE = 0;
    private final String carName;
    private int distance;

    public Car(String carName) {
        this.carName = carName;
        this.distance = DISTANCE_INIT_VALUE;
    }

    public Car(String carName, int mockedDistance) {
        this.carName = carName;
        this.distance = mockedDistance;
    }

    public int compareTo(Car otherCar) {
        return this.distance - otherCar.distance;
    }

    public void move(int movingCriteria) {
        if (movingCriteria >= 4) {
            goForward();
        }
    }

    private void goForward() {
        distance++;
    }

    public void setDistanceForTest(int mockedDistanceValue) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, distance);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", distance=" + distance +
                '}';
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

}
