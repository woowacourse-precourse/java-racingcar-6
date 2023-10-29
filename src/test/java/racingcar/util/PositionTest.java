package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

public class PositionTest {
    @Test
    @DisplayName("랜덤 숫자가 범위 내에 있는지 테스트")
    void 생성() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    void 이동() {
        Position position = new Position(3);
        assertThat(position.move()).isEqualTo(new Position(4));
    }

    @Test
    void 음수일때_예외() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
