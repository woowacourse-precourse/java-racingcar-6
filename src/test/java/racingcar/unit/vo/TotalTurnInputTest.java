package racingcar.unit.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.config.RacingCarRule;
import racingcar.game.vo.TotalTurnInput;

class TotalTurnInputTest {

    @Nested
    @DisplayName("입력된 시도 횟수에 대한 유효성 검사 시")
    class create {

        @DisplayName("유효성 검사가 성공하면 생성한다.")
        @Test
        void success() {
            //given
            String input = String.valueOf(RacingCarRule.MAX_TOTAL_TURN);

            //when
            TotalTurnInput totalTurnInput = new TotalTurnInput(input);

            //then
            assertThat(totalTurnInput).isNotNull();
            assertThat(totalTurnInput.input()).isEqualTo(input);
        }

        @DisplayName("시도 횟수 입력의 최대 길이를 넘은 경우 예외를 발생시킨다.")
        @Test
        void fail_InvalidLength() {
            //given
            String input = String.valueOf(RacingCarRule.MAX_TOTAL_TURN + 1);

            //when then
            assertThatThrownBy(() -> new TotalTurnInput(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("공백인 경우 예외를 발생시킨다.")
        @NullAndEmptySource
        @ParameterizedTest
        void fail_BlankInput(String input) {
            //given
            //when then
            assertThatThrownBy(() -> new TotalTurnInput(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자 이외 문자가 있는 경우 예외를 발생시킨다.")
        @ValueSource(strings = {"df", "1 3", "23-", "-sdc"})
        @ParameterizedTest
        void fail_InvalidFormat(String input) {
            //given
            //when then
            assertThatThrownBy(() -> new TotalTurnInput(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}