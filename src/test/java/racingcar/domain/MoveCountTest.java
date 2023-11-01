package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"five", "오", "다섯"})
    void 이동횟수의_값이_숫자가_아닌_문자로_생성되면_예외_발생(String inputMoveCount) {
        assertThatThrownBy(() -> MoveCount.valueOf(inputMoveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", " 1", "1 ", "1 0"})
    void 이동횟수의_값에_공백이_포함되면_예외_발생(String inputMoveCount) {
        assertThatThrownBy(() -> MoveCount.valueOf(inputMoveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}