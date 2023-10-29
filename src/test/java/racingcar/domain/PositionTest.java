package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Position;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    void positionTest() {
        //given
        Position position = Position.setStartPosition();

        //then
        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    void moveTest() {
        //given
        Position position = Position.setStartPosition();
        MoveCondition condition = MoveCondition.MOVE;

        //when
        position.move(condition.getDistance());

        //then
        assertThat(position.getValue()).isEqualTo(1);
    }
}
