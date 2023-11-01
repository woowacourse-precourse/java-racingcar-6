package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MoveTest {

    private static final int RANDOM_NUMBER = 4;

    @DisplayName("전진 테스트")
    @Test
    void move() {
        assertTrue(Move.isMove(RANDOM_NUMBER));
    }
}