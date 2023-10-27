package racingcar.domain;

import org.junit.jupiter.api.Test;

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

        //when
        position.move();

        //then
        assertThat(position.getValue()).isEqualTo(1);
    }
}
