package racingcar.domain;

import java.util.List;

public class Game {
    private final Movement move;
    private final List<Car> cars;
    private final int attemptNumber;

    public Game(List<Car> cars, int attemptNumber) {
        this.cars = cars;
        this.attemptNumber = attemptNumber;
        move = new Movement();
    }

}
