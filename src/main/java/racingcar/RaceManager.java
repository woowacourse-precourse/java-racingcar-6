package racingcar;

import java.util.List;

public class RaceManager {
    private List<Car> cars;
    private int rounds;

    public RaceManager(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }
}
