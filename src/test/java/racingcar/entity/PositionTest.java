package racingcar.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Position position = Position.newInstance();
        Position otherPosition = Position.newInstance();

        assertThat(position).isEqualTo(otherPosition);
    }

    @DisplayName("위치는 항상 0부터 시작한다.")
    @Test
    void initialPosition() {
        Position position = Position.newInstance();

        assertThat(position.getPosition()).isEqualTo(0);
    }
}
