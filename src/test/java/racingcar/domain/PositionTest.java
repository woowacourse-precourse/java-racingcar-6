package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("자동차 위치 전진")
    void givenPosition_whenMoveForward_thenIncreasePosition() {
        // given
        Position position = new Position();

        // when
        position.moveForward();

        // then
        assertThat(position.getPosition()).isEqualTo(1);
    }

}
