package racingcar.domain;

import java.util.List;

public class Game {
    Cars cars;

    public Game(Cars cars) {
        this.cars = cars;
    }

    public void racing() {
        cars.racing();

    }

    public List<Car> giveResult() {
        return cars.giveResult();
    }

    public String findWinner() {
        return cars.findWinner();
    }
}
