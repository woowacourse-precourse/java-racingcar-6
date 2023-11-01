package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("움직이는 조건 객체에 대해 ")
class MovingConditionTest {

    private final MovingCondition movingCondition = new MovingCondition();

    @Test
    @DisplayName("레이싱 카는 움직일 수도 있고 안 움직일 수도 있다.")
    void can_move_condition() {
        //given
        //when
        boolean canMove = movingCondition.canMove();

        //then
        assertThat(canMove).isIn(true, false);
    }
}
