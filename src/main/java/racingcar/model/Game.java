package racingcar.model;

import java.util.List;

public class Game {

    private final List<Car> cars;
    private final int totalRounds;
    private int completedRounds;

    public Game(List<Car> cars, int totalRounds) {
        this.cars = cars;
        this.totalRounds = totalRounds;
        this.completedRounds = 0;
    }

}
