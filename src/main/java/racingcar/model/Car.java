package racingcar.model;

import java.util.List;

public class Car {

    private final List<String> name;
    private final int count;

    public Car(List<String> name, int count) {
        this.name = name;
        this.count = count;
    }
}
