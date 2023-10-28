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

    @Test
    @DisplayName("of 메서드는 Position 위치를 마음대로 설정할 수 있다.")
    void of() {
        Position position = Position.of(3);
        assertThat(position).isEqualTo(Position.of(3));
    }

    @Test
    @DisplayName("Position은 1씩 증가한다.")
    void move() {
        Position position = Position.startFromZero();
        assertThat(position.move()).isEqualTo(Position.of(1));
    }

    @Test
    @DisplayName("compareTo 메서드는 Position을 비교한다.")
    void compareTo() {
        Position position = Position.of(3);
        assertThat(position.compareTo(Position.of(2))).isEqualTo(1);
    }

    @Test
    @DisplayName("toString 메서드는 Position을 -로 표현한다.")
    void toStringTest() {
        Position position = Position.of(3);
        assertThat(position.toString()).isEqualTo("---");
    }
}