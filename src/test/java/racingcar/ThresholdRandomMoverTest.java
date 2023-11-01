package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ThresholdRandomMoverTest {

    @Test
    @DisplayName("임계값을 가진 랜덤 이동 전략은 임계값 이상일 때 움직일 수 있다")
    void threshold_random_mover_move_true() {
        int minRandomBound = 0;
        MovingStrategy thresholdRandomMover =
                new ThresholdRandomMover(minRandomBound, 10, minRandomBound);
        assertThat(thresholdRandomMover.isMovable()).isTrue();
    }

    @Test
    @DisplayName("임계값을 가진 랜덤 이동 전략은 임계값 이하일 때 움직일 수 없다")
    void threshold_random_mover_move_false() {
        int maxRandomBound = 0;
        MovingStrategy thresholdRandomMover =
                new ThresholdRandomMover(0, maxRandomBound, maxRandomBound + 1);
        assertThat(thresholdRandomMover.isMovable()).isFalse();
    }
}
