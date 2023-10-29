package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    void createPositionWithIncrease(){
        int initPosition = 0;
        Position position = Position.getIncreasedPosition(initPosition);
        assertThat(position).isEqualTo(new Position(1));
    }
}
