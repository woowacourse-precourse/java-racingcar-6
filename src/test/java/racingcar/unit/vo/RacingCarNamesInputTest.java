package racingcar.unit.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.common.config.RacingCarRule;
import racingcar.game.vo.RacingCarNamesInput;

class RacingCarNamesInputTest {

    @Nested
    @DisplayName("경주 자동차 이름 입력에 대한 유효성 검사 시")
    class create {

        @DisplayName("유효성 검사가 성공하면 생성한다.")
        @Test
        void success() {
            //given
            String name = "a".repeat(RacingCarRule.MAX_RACER_NAME_LENGTH);
            String input = name + name.repeat(RacingCarRule.MAX_RACER_SIZE - 1);

            //when
            RacingCarNamesInput racingCarNamesInput = new RacingCarNamesInput(input);

            //then
            assertThat(racingCarNamesInput).isNotNull();
            assertThat(racingCarNamesInput.input()).isEqualTo(input);
        }

        @DisplayName("시도 횟수 입력의 최대 길이를 넘은 경우 예외를 발생시킨다.")
        @Test
        void fail_InvalidLength() {
            //given
            String input = "a".repeat(RacingCarRule.MAX_RACER_NAME_INPUT_LENGTH + 1);

            //when then
            assertThatThrownBy(() -> new RacingCarNamesInput(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("공백인 경우 예외를 발생시킨다.")
        @NullAndEmptySource
        @ParameterizedTest
        void fail_BlankInput(String input) {
            //given
            //when then
            assertThatThrownBy(() -> new RacingCarNamesInput(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}