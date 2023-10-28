package racingcar.common.strategy;

import racingcar.common.generator.RandomGenerator;

public class MoveStrategy {
    private static final int MOVABLE_THRESHOLD = 4;
    private final RandomGenerator randomGenerator;


    public MoveStrategy(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public boolean isMovable() {
        return randomGenerator.generate() >= MOVABLE_THRESHOLD;
    }
}
