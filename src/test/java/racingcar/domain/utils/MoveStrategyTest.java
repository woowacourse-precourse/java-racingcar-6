package racingcar.domain.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveStrategyTest {

    @Test
    @DisplayName("무작위값이 4이상인 경우 전진할 수 있습니다")
    void movable() {
        // GIVEN
        int pickedNumber = 4;

        // WHEN
        boolean movable = MoveStrategy.isMovable(pickedNumber);

        // THEN
        assertTrue(movable);
    }
    @Test
    @DisplayName("무작위값이 4미망닝 경우 전진할 수 없습니다")
    void unMovable() {
        // GIVEN
        int pickedNumber = 3;

        // WHEN
        boolean movable = MoveStrategy.isMovable(pickedNumber);

        // THEN
        assertFalse(movable);
    }
}