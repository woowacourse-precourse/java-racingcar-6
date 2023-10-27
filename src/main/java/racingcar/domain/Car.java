package racingcar.domain;

import java.util.List;

public class Car {

    private String name;
    private List<String> position;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getPosition() {
        return position;
    }
}
