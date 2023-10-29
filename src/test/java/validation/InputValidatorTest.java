package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.validation.InputValidator.validateInputNameLength;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    // validateInputNameLength Test
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi", "woni", "abcde"})
    void 설정된_값_범위_안에_들어온다면_통과(String name) {
        validateInputNameLength(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abcdefg"})
    void 설정된_값보다_긴_문자열이_들어오면_예외_처리(String name) {
        assertThatThrownBy(() -> validateInputNameLength(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void 아무것도_입력하지_않았다면_예외_처리(String name) {
        assertThatThrownBy(() -> validateInputNameLength(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // readAttemptCount Test

}
