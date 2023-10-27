package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class MovingStrategy {

    private final RandomNumberGenerator randomNumberGenerator;

    public MovingStrategy(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }
}
