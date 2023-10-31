package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PositionTest {

    @Test
    void 유효하지않은_Position생성시_오류() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 값객체는_동등성을_지님() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    void move호출시_distance값_1증가한_Position반환() {
        //given
        Position position = new Position(1);
        //when
        Position movedPosition = position.move();
        //then
        assertThat(movedPosition).isEqualTo(new Position(2));
    }
}
