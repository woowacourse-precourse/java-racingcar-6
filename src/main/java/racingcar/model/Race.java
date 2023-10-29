package racingcar.model;

import java.util.List;

public class Race {
    private int order = 0;
    private final List<Car> cars;

    private final int numRaces;

    public Race(int numRaces, List<Car> cars) {
        this.cars = cars;
        this.numRaces = numRaces;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void increaseGameOrder() {
        this.order++;
    }

    public boolean checkGamesExhausted() {
        return this.order >= this.numRaces;
    }
}
