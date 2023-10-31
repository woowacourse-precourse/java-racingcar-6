package racingcar.common.strategy;

import racingcar.common.generator.RandomGenerator;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVABLE_THRESHOLD = 4;
    private final RandomGenerator randomGenerator;

    private RandomMoveStrategy(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    // 움직임 전략 생성
    public static RandomMoveStrategy of(RandomGenerator randomGenerator) {
        return new RandomMoveStrategy(randomGenerator);
    }

    @Override
    public boolean isMovable() {
        return randomGenerator.generate() >= MOVABLE_THRESHOLD;
    }
}
