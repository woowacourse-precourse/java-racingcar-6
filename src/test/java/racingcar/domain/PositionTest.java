package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PositionTest {
    @Test
    void Position에_4이상_숫자를_입력하면_증가하는지() {
        Position position = Position.create(0);
        position.plusNum(4);
        assertThat(position.getNum()).isEqualTo(1);
    }

    @Test
    void Position에_4미만_숫자를_입력하면_변화가_없는지() {
        Position position = Position.create(0);
        position.plusNum(3);
        assertThat(position.getNum()).isEqualTo(0);
    }
}