package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 자동차의_이름은_최소_1글자여야_한다() {
        // given
        String emptyName = "";

        // when, then
        assertThatThrownBy(() -> InputValidator.validateCarNames(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("the car name cannot be empty");
    }

    @Test
    void 자동차의_이름은_공백이_포함될_수_없다() {
        // given
        String blankName = " ";
        String blankContainName = " pobi";

        // when, then
        assertThatThrownBy(() -> {
            InputValidator.validateCarNames(blankName);
            InputValidator.validateCarNames(blankContainName);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("the car name cannot be blank");
    }

    @Test
    void 자동차의_이름은_5글자_이하여야_한다() {
        // given
        String longName = "helloCar";

        // when, then
        assertThatThrownBy(() -> InputValidator.validateCarNames(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("the car name length cannot over 5 characters");
    }

    @Test
    void 자동차_경주의_시도_횟수는_숫자로_입력해야_한다() {
        // given
        String round = "5번";

        // when, then
        assertThatThrownBy(() -> InputValidator.validateRaceRoundString(round))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("the race round must be numeric value");
    }

    @Test
    void 자동차_경주의_시도_횟수는_1_이상이어야_한다() {
        // given
        int round = 0;

        // when, then
        assertThatThrownBy(() -> InputValidator.validateRaceRound(round))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("the race round cannot be under 1");
    }
}