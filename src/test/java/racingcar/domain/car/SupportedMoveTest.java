package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.car.SupportedMove.*;

class SupportedMoveTest {

    @Test
    @DisplayName("4이상의 값이면 한번 움직일 수 있다.")
    public void moveCalculateTest() {
        // given
        int moveCount = 3;
        // when
        int calculateValue = controlMovement(moveCount, 4);
        // then
        assertThat(moveCount + 1).isEqualTo(calculateValue);
    }

    @Test
    @DisplayName("4미만의 값이면 움직이지 않는다.")
    public void stopCalculateTest() {
        // given
        int moveCount = 3;
        // when
        int calculateValue = controlMovement(moveCount, 3);
        // then
        assertThat(moveCount).isEqualTo(calculateValue);
    }

}