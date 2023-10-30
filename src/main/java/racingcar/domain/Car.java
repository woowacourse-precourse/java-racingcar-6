package racingcar.domain;

import java.util.List;

public class Car {
    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void go() {
        location++;
    }

    public void stop() {
    }
}
