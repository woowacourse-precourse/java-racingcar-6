package racingcar;

import java.util.Objects;

public class Car {
    private final String carName;
    private int distance;

    public Car(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public void move(int movingCriteria) {
        if (movingCriteria >= 4) {
            goForward();
        }
    }

    private void goForward() {
        distance++;
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

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }


}
