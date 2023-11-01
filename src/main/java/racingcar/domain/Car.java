package racingcar.domain;

import java.util.Objects;

public class Car {
    String name;
    long distance;

    private Car() {

    }
    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public void addDistance() {
        distance++;
    }

    public boolean isDuplicate(String name) {
        return Objects.equals(this.name, name);
    }

    public String getName() {
        return name;
    }

    public long getDistance() {
        return distance;
    }

}
