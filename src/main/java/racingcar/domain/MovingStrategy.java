package racingcar.domain;

import racingcar.util.RandomNumberGenerator;
import racingcar.util.RandomUtil;

public class MovingStrategy {

    private static final Integer POSSIBLE_NUMBER = 4;
    private final RandomUtil randomNumberGenerator;

    public MovingStrategy(RandomUtil randomNumberGenerator) {
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
