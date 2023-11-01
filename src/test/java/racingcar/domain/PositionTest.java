package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {

    private Position initPosition;

    @BeforeEach
    void setUp() {
        initPosition = new Position(0);
    }

    @Test
    void createPositionWithIncrease() {
        Position position = Position.getIncreasedPosition(initPosition.getPosition());
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    void createPositionWithPause() {
        Position position = Position.getPausedPosition(initPosition.getPosition());
        assertThat(position).isEqualTo(new Position(0));
    }
}

