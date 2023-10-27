package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class MovingStrategy {

    private final RandomNumberGenerator randomNumberGenerator;

    public MovingStrategy(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Boolean isCarMove() {
        Integer number = generateNumber();
        return number >= 4 ? true : false;
    }

    private Integer generateNumber() {
        return randomNumberGenerator.generate();
    }
}
