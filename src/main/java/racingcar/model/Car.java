package racingcar.model;

import java.util.List;

public class Car {
    private final List<String> name;

    public Car(List<String> name) {
        this.name = name;
    }

    public List<String> getCarName() {
        return name;
    }
}
