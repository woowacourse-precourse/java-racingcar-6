package racingcarv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcarv2.model.Position;

public class PositionTest {
    private Position position;
    @Test
    void increase_하면_positionValue_증가() {
        position = new Position(1);

        position.increase();

        Assertions.assertThat(position).isEqualTo(new Position(2));
    }

}
