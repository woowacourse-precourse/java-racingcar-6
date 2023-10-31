package racingcar.domain;

import java.util.List;

public class Game {

    private int trials;
    private List<Car> cars;
    private int currentTrial;

    public Game(List<Car> cars, int trials) {
        this.cars = cars;
        this.trials = trials;
        this.currentTrial = 0;
    }
}
