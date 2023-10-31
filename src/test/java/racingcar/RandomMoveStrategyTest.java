package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.util.RandomNumberGenerator;

class RandomMoveStrategyTest {

    private static class FixedNumberGenerator extends RandomNumberGenerator {
        private final int fixedNumber;

        public FixedNumberGenerator(int fixedNumber) {
            this.fixedNumber = fixedNumber;
        }

        @Override
        public int getNumber() {
            return fixedNumber;
        }
    }

    @Test
    void 항상_4를_반환하는_랜덤넘버() {
        RandomNumberGenerator generator = new FixedNumberGenerator(4);
        RandomMoveStrategy strategy = new RandomMoveStrategy(generator);

        assertThat(strategy.isMovable()).isTrue();
    }

    @Test
    void 항상_3을_반환하는_랜덤넘버() {
        RandomNumberGenerator generator = new FixedNumberGenerator(3);
        RandomMoveStrategy strategy = new RandomMoveStrategy(generator);

        assertThat(strategy.isMovable()).isFalse();
    }
}
