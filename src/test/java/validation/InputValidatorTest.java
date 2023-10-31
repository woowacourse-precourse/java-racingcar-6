package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.validation.InputValidator.validateInputName;
import static racingcar.validation.InputValidator.validateNumericInput;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    int maxLength = 5;

    // validateInputName Test
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi", "woni", "abcde"})
    void 설정된_값_범위_안에_들어온다면_통과(String name) {
        validateInputName(name, maxLength);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abcdefg"})
    void 설정된_값보다_긴_문자열이_들어오면_예외_처리(String name) {
        assertThatThrownBy(() -> validateInputName(name, maxLength))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"po bi", " woni", "jun "})
    void 공백이_포함되어_있다면_예외_발생(String name) {
        assertThatThrownBy(() -> validateInputName(name, maxLength))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 아무것도_입력하지_않았다면_예외_name(String name) {
        assertThatThrownBy(() -> validateInputName(name, maxLength))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // validateNumericInput Test
    @ParameterizedTest
    @ValueSource(strings = {"1", "10"})
    void 숫자가_들어오면_통과(String input) {
        validateNumericInput(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1a"})
    void 숫자가_아닌_값이_들어오면_예외_발생(String input) {
        assertThatThrownBy(() -> validateNumericInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 아무것도_입력하지_않았다면_예외_처리_numeric(String input) {
        assertThatThrownBy(() -> validateInputName(input, maxLength))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
