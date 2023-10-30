package racingcar.domain;

import static racingcar.config.GameConfig.INITIAL_DISTANCE;

public class Car {
    private final String name;
    private int distance;

    public Car(final String name) {
        this.name = name;
        this.distance = INITIAL_DISTANCE;
    }
}
