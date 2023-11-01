package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void validateCarNames_메서드에_범위_이상의_자동차_이름_입력시_예외_발생() {
        String[] input = {"aaa", "bbbb", "ccccccc"};

        assertThatThrownBy(() -> Validator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateAttemptsNumber_메서드에_숫자로_변환_불가능한_값_입력시_예외_발생() {
        String input = "13aa";

        assertThatThrownBy(() -> Validator.validateRoundNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateAttemptsRange_메서드에_범위_미만의_값_입력시_예외_발생() {
        String input = "-1";

        assertThatThrownBy(() -> Validator.validateRoundRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}