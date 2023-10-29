package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Car {

    private final String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car nameFrom(String name) {
        return new Car(name, 0);
    }
}
