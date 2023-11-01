package racingcar.domain;

import java.util.Objects;

public class Car {
    String name;

    private Car() {

    }
    public Car(String name) {
        this.name = name;
    }

    public boolean isDuplicate(String name) {
        return Objects.equals(this.name, name);
    }
}
