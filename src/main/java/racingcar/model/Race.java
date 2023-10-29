package racingcar.model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Race {

    private final Set<Car> cars = new LinkedHashSet<>();
    private int gameCount;

    public void add(Car car) {
        cars.add(car);
    }

    public Set<Car> getCars() {
        return Collections.unmodifiableSet(cars);
    }

    public int getGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }
}
