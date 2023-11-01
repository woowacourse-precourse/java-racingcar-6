package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.InputValidator;

public class InputValidatorTest {

    @ParameterizedTest
    @EmptySource
    void 플레이어_이름의_입력형식이_공백이면_예외를_발생한다(String empty) {
        assertThatThrownBy(() -> InputValidator.validatePlayerNames(empty)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"roseLisa", "rose,,lisa", ",rose,lisa", "rose,lisa,", "rose,"})
    void 플레이어_이름의_입력형식이_콤마로_구분되지_않으면_예외를_발생한다(String names) {
        assertThatThrownBy(() -> InputValidator.validatePlayerNames(names)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"rose,lisa", "rose,lisa,jisu,jenny"})
    void 플레이어_이름의_입력형식이_콤마로_구분되어_들어오면_예외를_발생시키지_않는다(String names) {
        assertDoesNotThrow(() -> InputValidator.validatePlayerNames(names));
    }

    @ParameterizedTest
    @EmptySource
    void 시도횟수의_입력형식이_공백이면_예외를_발생한다(String empty) {
        assertThatThrownBy(() -> InputValidator.validateRaceCount(empty))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수의_입력형식이_숫자가_아니면_예외를_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateRaceCount("a1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수의_입력형식이_숫자면_예외를_발생시키지_않는다() {
        assertDoesNotThrow(() -> InputValidator.validateRaceCount("11"));
    }
}
