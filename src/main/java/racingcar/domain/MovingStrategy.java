package racingcar.domain;

import racingcar.util.RandomNumberUtil;

import static racingcar.config.MovingStrategyConfig.*;

public class MovingStrategy {

    private final RandomNumberUtil randomNumberGenerator;

    public MovingStrategy(final RandomNumberUtil randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Boolean isCarMove() {
        Integer number = generateNumber();
        return number >= MOVABLE_NUMBER.getSetting();
    }

    private Integer generateNumber() {
        return randomNumberGenerator.generate(
                RANGE_START_NUMBER.getSetting(),
                RANGE_END_NUMBER.getSetting()
        );
    }
}
