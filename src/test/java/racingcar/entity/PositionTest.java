package racingcar.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("위치는 항상 0부터 시작한다.")
    @Test
    void initialPosition() {
        Position position = Position.newInstance();

        assertThat(position.getPosition()).isEqualTo(0);
    }

    @DisplayName("위치를 증가할 수 있다.")
    @Test
    void increase() {
        Position position = Position.newInstance();

        position.increase();

        assertThat(position.getPosition()).isEqualTo(1);
    }
}
