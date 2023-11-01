package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.RacingConfig.MOVE_FORWARD_VALUE;

import org.junit.jupiter.api.Test;
import racingcar.domain.movement.TestMovementStrategy;

public class MovementStrategyTest {
    @Test
    void could_move() {
        TestMovementStrategy testMovementStrategy = new TestMovementStrategy(MOVE_FORWARD_VALUE);
        assertThat(testMovementStrategy.couldMove()).isTrue();
    }

    @Test
    void could_not_move() {
        TestMovementStrategy testMovementStrategy = new TestMovementStrategy(MOVE_FORWARD_VALUE - 1);
        assertThat(testMovementStrategy.couldMove()).isFalse();
    }
}
