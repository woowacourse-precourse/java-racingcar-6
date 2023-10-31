package racingcar;

import java.util.List;

public class Game {
    private final List<Car> cars;
    private final int raceCount;

    public Game(List<Car> cars, int raceCount) {
        this.cars = cars;
        this.raceCount = raceCount;
    }
}
