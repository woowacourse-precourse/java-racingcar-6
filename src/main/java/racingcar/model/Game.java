package racingcar.model;

import racingcar.util.NumberGenrator;
import racingcar.util.RandomNumberGenrator;

public class Game {
    private final Cars racingCars;
    private final int tryCount;
    private final static NumberGenrator randomNumberGenerator = new RandomNumberGenrator();

    public Game(Cars cars, int tryCount) {
        this.racingCars = cars;
        this.tryCount = tryCount;
    }
}
