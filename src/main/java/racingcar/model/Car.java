package racingcar.model;

import java.util.Objects;

public class Car {
    private String name;
    private int distance;
    public Car(String name) {
        this.name = name;
        this.distance = 0;
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
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            distance++;
        }
    }

}
