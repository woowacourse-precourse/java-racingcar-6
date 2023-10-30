package racingcar.model;

import racingcar.util.RandomDistanceGenerator;

public class Car {
    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }
}
