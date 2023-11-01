package racingcar.model;

import java.util.Objects;

public class Car {
    private String name;
    private Integer distance;

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public Car(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    public void updateDistance() {
        this.distance++;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
