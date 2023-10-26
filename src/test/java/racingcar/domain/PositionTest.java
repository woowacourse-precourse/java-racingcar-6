package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("자동차의 위치를 알 수 있다.")
    void createPosition() {
        Position position = new Position(0);
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("자동차의 위치가 0보다 작다면 예외가 발생한다.")
    void invalidPosition() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 위치는 0보다 작을 수 없습니다.");
    }
}