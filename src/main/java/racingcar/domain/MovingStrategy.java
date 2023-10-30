package racingcar.domain;

import racingcar.util.RandomNumberGenerator;
import racingcar.util.RandomUtil;

import static racingcar.domain.MovingStrategySetting.*;

public class MovingStrategy {

    private final RandomUtil randomNumberGenerator;

    public MovingStrategy(RandomUtil randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Boolean isCarMove() {
        Integer number = generateNumber();
        return number >= MOVABLE_NUMBER.getSetting() ? true : false;
    }

    private Integer generateNumber() {
        return randomNumberGenerator.generate();
    }
}
