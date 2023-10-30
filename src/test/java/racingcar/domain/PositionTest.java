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
    void move호출시_distance값_1증가한_Position반환() {
        Position position = new Position(1);
        Position movedPosition = position.move();
        assertThat(movedPosition).isEqualTo(new Position(2));
    }
}
