package racingcar.domain.game;

import racingcar.domain.car.Cars;

public class RacingCarGame {
    private Cars cars;
    private int round;

    public void init(String names, int round) {
        cars = generateCars(names);
        this.round = round;
    }

    private Cars generateCars(String names) {
        return new Cars(names);
    }
}
