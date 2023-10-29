package racingcar.model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Race {

    private Cars cars;
    private GameCount gameCount;

    private Race(Cars cars, GameCount gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public static Race of(Cars cars, GameCount gameCount) {
        return new Race(cars, gameCount);
    }
}
