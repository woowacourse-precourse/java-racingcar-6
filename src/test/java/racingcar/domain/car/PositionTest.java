package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    void 위치_반환_테스트() {
        //given
        Position position = new Position();

        //then
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void 위치_이동_테스트() {
        //given
        Position position = new Position();

        //when
        position.moveForward(7);

        //then
        assertThat(position.getPosition()).isEqualTo(1);
    }
}
