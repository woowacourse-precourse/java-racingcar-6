package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    @DisplayName("자동차가 이동함에 따라 Position을 전진시킨다")
    void moveForward() {
        /* init */
        final Position init = Position.init();
        Assertions.assertThat(init.getValue()).isEqualTo(0);

        /* moveForward 1 */
        final Position move1 = init.moveForward();
        Assertions.assertThat(move1.getValue()).isEqualTo(1);

        /* moveForward 2 */
        final Position move2 = move1.moveForward();
        Assertions.assertThat(move2.getValue()).isEqualTo(2);
    }
}
