package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    @DisplayName("자동차가 이동함에 따라 Position을 전진시킨다")
    void moveForward() {
        /* init */
        final Position init = Position.init();
        assertThat(init.getValue()).isEqualTo(0);

        /* moveForward 1 */
        final Position move1 = init.moveForward();
        assertThat(move1.getValue()).isEqualTo(1);

        /* moveForward 2 */
        final Position move2 = move1.moveForward();
        assertThat(move2.getValue()).isEqualTo(2);
    }

    @Test
    @DisplayName("Position을 비교한다")
    void compareTo() {
        // given
        final Position position1 = Position.init().moveForward();
        final Position position2 = Position.init().moveForward();

        /* same */
        assertThat(position1.compareTo(position2)).isEqualTo(0); // 1 == 2

        /* position1 win */
        final Position movedPosition1 = position1.moveForward();
        assertThat(movedPosition1.compareTo(position2)).isEqualTo(1); // 1 > 2

        /* position2 win */
        final Position movedPosition2 = position2.moveForward().moveForward();
        assertThat(movedPosition1.compareTo(movedPosition2)).isEqualTo(-1); // 1 < 2
    }
}
