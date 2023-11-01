package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

public class PositionTest {
    @Test
    @DisplayName("position이 범위 3이하 이면 스톱 테스트")
    void 생성() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    @DisplayName("position이 범위 4이상 이면 전진 테스트")
    void 이동() {
        Position position = new Position(3);
        assertThat(position.move()).isEqualTo(new Position(4));
    }

    @Test
    @DisplayName("position이 음수 값이 주어질때 예외 테스트")
    void 음수일때_예외() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
