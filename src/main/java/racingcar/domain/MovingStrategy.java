package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class MovingStrategy {

    private static final Integer POSSIBLE_NUMBER = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public MovingStrategy(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Boolean isCarMove() {
        Integer number = generateNumber();
        return number >= POSSIBLE_NUMBER ? true : false;
    }

    private Integer generateNumber() {
        return randomNumberGenerator.generate();
    }
}
