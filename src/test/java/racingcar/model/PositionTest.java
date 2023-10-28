package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("Position은 항상 0부터 시작한다.")
    void startFromZero() {
        Position position = Position.startFromZero();
        assertThat(position).isEqualTo(Position.startFromZero());
    }
}