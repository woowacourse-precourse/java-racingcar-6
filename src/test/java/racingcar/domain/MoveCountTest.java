package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MoveCountTest {

    @Test
    void 이동횟수를_입력하면_입력한_숫자를_가진_객체로_반환() {
        //given
        String inputMoveCount = "5";

        //when
        MoveCount moveCount = MoveCount.valueOf(inputMoveCount);

        //then
        assertThat(moveCount.intValue()).isEqualTo(5);
    }

    @Test
    void 이동횟수가_문자로_생성되면_예외_발생() {
        String moveCount = "a";

        assertThatThrownBy(() -> MoveCount.valueOf(moveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동횟수가_공백으로_생성되면_예외_발생() {
        String moveCount = " ";

        assertThatThrownBy(() -> MoveCount.valueOf(moveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동횟수가_빈값으로_생성되면_예외_발생() {
        String moveCount = "";

        assertThatThrownBy(() -> MoveCount.valueOf(moveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동횟수가_1보다_작으면_예외_발생() {
        String moveCount = "0";

        assertThatThrownBy(() -> MoveCount.valueOf(moveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}