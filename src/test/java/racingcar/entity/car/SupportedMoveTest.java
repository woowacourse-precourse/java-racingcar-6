package racingcar.entity.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racingcar.entity.car.SupportedMove.*;

class SupportedMoveTest {

    @Test
    @DisplayName("moveCount를 하나 증가시킬 수 있다.")
    public void moveCalculateTest() {
        // given
        int moveCount = 3;
        // when
        int calculateValue = MOVE.calculate(moveCount);
        // then
        assertThat(moveCount + 1).isEqualTo(calculateValue);
    }

    @Test
    @DisplayName("moveCount는 변하지 않는다.")
    public void stopCalculateTest() {
        // given
        int moveCount = 3;
        // when
        int calculateValue = STOP.calculate(moveCount);
        // then
        assertThat(moveCount).isEqualTo(calculateValue);
    }

}