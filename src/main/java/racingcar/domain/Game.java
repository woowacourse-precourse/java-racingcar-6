package racingcar.domain;

import java.util.List;

public class Game {
    private Cars cars;

    public Game(Cars cars) {
        this.cars = cars;
    }

    public void racing() {
        cars.racing();
    }

    public List<Unchangeable> giveResult() {
        return cars.giveCopiedResult();
    }

    public String findWinner() {
        return cars.findWinner();
    }
}
