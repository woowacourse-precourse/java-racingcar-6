package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.movement.MovementHistory;

public class MovementHistoryTest {
    private MovementHistory movementHistory;

    @BeforeEach
    void setUp() {
        movementHistory = new MovementHistory();
    }
    @Test
    void initial_movement_history() {
        assertThat(movementHistory.getMovedDistance()).isZero();
    }

    @Test
    void should_increment_distance_when_movement_recorded() {
        movementHistory.recordMovement(true);
        assertThat(movementHistory.getMovedDistance()).isEqualTo(1);
    }

    @Test
    void should_not_change_distance_when_no_movement_recorded() {
        movementHistory.recordMovement(false);
        assertThat(movementHistory.getMovedDistance()).isEqualTo(0);
    }

    @Test
    void validate_is_max_distance() {
        for (int i = 0; i < 5; i++) {
            movementHistory.recordMovement(true);
        }
        assertThat(movementHistory.isMaxDistance(5)).isTrue();
    }

    @Test
    void validate_is_not_max_distance() {
        for (int i = 0; i < 5; i++) {
            movementHistory.recordMovement(true);
        }
        assertThat(movementHistory.isMaxDistance(6)).isFalse();
    }
}
