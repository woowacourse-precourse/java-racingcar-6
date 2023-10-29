package racingcar.model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Race {

    private Cars cars;
    private int gameCount;

    private Race(Cars cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public static Race of(Cars cars, int gameCount) {
        return new Race(cars, gameCount);
    }

    public int getGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }
}
