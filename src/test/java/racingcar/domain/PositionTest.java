package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {
    Position position;

    @Test
    void 생성_테스트() {
        position = new Position();

        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    void 값_증가_테스트() {
        position = new Position();

        position.moveBy(3);

        assertThat(position.getValue()).isEqualTo(3);
    }
}
