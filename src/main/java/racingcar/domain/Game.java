package racingcar.domain;

import racingcar.config.GameConfig;
import racingcar.util.NumberGenerator;

public class Game {

    private final NumberGenerator numberGenerator;
    private final Cars cars;
    private final int numberOfAttempts;

    public Game(NumberGenerator numberGenerator, Cars cars, int numberOfAttempts) {
        validateNumberOfAttempts(numberOfAttempts);
        this.numberGenerator = numberGenerator;
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
    }

    private static void validateNumberOfAttempts(int numberOfAttempts) {
        if (numberOfAttempts <= GameConfig.ATTEMPTS_MIN_VALUE) {
            throw new IllegalArgumentException();
        }
    }
}
