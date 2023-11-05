package racingcar.data.attempt;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveTest {
    @DisplayName("0을 넣는 테스트")
    @Test
    void getMoveNumByMoves_0_OK() {
        // given
        int move = 0;

        // when, then
        assertThatCode(() -> Move.getNumByMove(move))
                .doesNotThrowAnyException();
    }

    @DisplayName("1을 넣는 테스트")
    @Test
    void getMoveNumByMoves_1_OK() {
        // given
        int move = 1;

        // when, then
        assertThatCode(() -> Move.getNumByMove(move))
                .doesNotThrowAnyException();
    }

    @DisplayName("0과 1이 아닌 값을 넣는 테스")
    @Test
    void validateCarName_NotLongerThan5_OK() {
        // given
        int move = -1;

        // when, then
        assertThatThrownBy(() -> Move.getNumByMove(move))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Moves should be 0 or 1.");
    }
}
