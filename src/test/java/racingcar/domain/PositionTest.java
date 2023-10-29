package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("position 값 1 증가")
    void moveTest() {
        // given
        Position position = new Position();

        // when
        position.move();

        // then
        Assertions.assertThat(position.getLawPosition()).isEqualTo(1);
    }
}
