package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void 포지션을_생성한다() {
        // given
        Position position = new Position(0);

        // then
        Assertions.assertThat(position).isEqualTo(new Position(0));
    }
}
