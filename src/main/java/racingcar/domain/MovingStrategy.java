package racingcar.domain;

import static racingcar.domain.MovingStrategySetting.*;

public class MovingStrategy {

    private final RandomNumberUtil randomNumberGenerator;

    public MovingStrategy(RandomNumberUtil randomNumberGenerator) {
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
