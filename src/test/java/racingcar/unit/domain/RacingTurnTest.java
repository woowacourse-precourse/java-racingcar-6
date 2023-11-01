package racingcar.unit.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.common.config.RacingCarRule;
import racingcar.domain.RacingTurn;

class RacingTurnTest {

    @Nested
    @DisplayName("시도 횟수의 유효성 검사 시")
    class create {

        @DisplayName("성공하면 성공적으로 생성한다.")
        @Test
        void success() {
            //given
            int totalTurn = RacingCarRule.MAX_TOTAL_TURN;

            //when
            RacingTurn racingTurn = RacingTurn.from(totalTurn);

            //then
            assertThat(racingTurn.getCount()).isEqualTo(totalTurn);
        }

        @DisplayName("시도 횟수 최대 크기보다 크다면 예외를 발생시킨다.")
        @Test
        void fail_GreaterThanMaxTotalTurn() {
            //given
            int totalTurn = RacingCarRule.MAX_TOTAL_TURN + 1;

            //when then
            assertThatThrownBy(() -> RacingTurn.from(totalTurn))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}