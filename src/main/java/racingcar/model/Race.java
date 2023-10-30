package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private int order = 0;
    private final List<Car> cars;

    private final int numRaces;

    public Race(List<Car> cars, int numRaces) {
        this.cars = new ArrayList<>(cars);
        this.numRaces = numRaces;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getNumRaces() {
        return this.numRaces;
    }

    public boolean checkGamesExhausted() {
        return this.order >= this.numRaces;
    }

    public void increaseGameOrder() {
        this.order++;
    }
}
