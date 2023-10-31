package racingcar.game.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.game.constant.RoundExceptionMessage;

import static org.assertj.core.api.Assertions.*;


class RoundTest {

    @Test
    void 라운드_객체_생성() {
        Round round = Round.create("5");
        assertThat(round).isNotNull();
    }

    @Test
    void 입력값이_정수가_아니면_예외_발생() {
        assertThatThrownBy(() -> Round.create("asdf"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasCauseInstanceOf(NumberFormatException.class)
                .hasMessageContaining(RoundExceptionMessage.NOT_INTEGER);
    }

}