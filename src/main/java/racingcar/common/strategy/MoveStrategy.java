package racingcar.common.strategy;

import racingcar.common.generator.NsRandomGenerator;
import racingcar.common.generator.RandomGenerator;

public class MoveStrategy {
    private static final int MOVABLE_THRESHOLD = 4;
    private final RandomGenerator randomGenerator;

    private MoveStrategy(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    // 움직임 전략 생성
    public static MoveStrategy of() {
        NsRandomGenerator randomGenerator = new NsRandomGenerator();
        return new MoveStrategy(randomGenerator);
    }

    public boolean isMovable() {
        return randomGenerator.generate() >= MOVABLE_THRESHOLD;
    }
}
