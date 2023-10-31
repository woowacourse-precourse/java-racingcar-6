package racingcar.game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.game.constant.RoundExceptionMessage.NOT_INTEGER;
import static racingcar.game.constant.RoundExceptionMessage.OUT_OF_RANGE;


class RoundTest {

    @Test
    void 라운드_객체_생성() {
        Round round = Round.create(5);
        assertThat(round).isNotNull();
    }

    @Test
    void 입력값이_범위_내_값이_아니면_예외_발생() {
        assertExceptionCase(0, OUT_OF_RANGE);
        assertExceptionCase(101, OUT_OF_RANGE);
    }

    private void assertExceptionCase(int movingCount, String errorMessage) {
        assertThatThrownBy(() -> Round.create(movingCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);

    }

}