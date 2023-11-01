package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Movement;
import racingcar.domain.Position;

public class PositionTest {
    Position position;

    @BeforeEach
    void beforeEach() {
        position = new Position();
    }

    @Test
    void 전진_한칸() {
        position.move(Movement.FORWARD);
        assertThat(position.getValue()).isEqualTo(1);
    }

    @Test
    void 전진_두칸() {
        position.move(Movement.FORWARD);
        position.move(Movement.FORWARD);

        assertThat(position.getValue()).isEqualTo(2);
    }

    @Test
    void 정지() {
        position.move(Movement.STOP);

        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    void 전진_정지_혼합() {
        position.move(Movement.STOP);
        position.move(Movement.FORWARD);
        position.move(Movement.STOP);
        position.move(Movement.FORWARD);
        position.move(Movement.STOP);

        assertThat(position.getValue()).isEqualTo(2);
    }
}