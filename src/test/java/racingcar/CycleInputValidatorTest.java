package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.CarNamesInputValidator;
import racingcar.util.CycleInputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CycleInputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "4"})
    void validate_자연수는_예외_미발생(String input) {
        assertDoesNotThrow(() -> CycleInputValidator.validate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validate_빈_문자열은_예외_발생(String input) {
        assertThatThrownBy(() -> CycleInputValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.1", "-1.5", "박현호", "$%@#"})
    void validate_자연수가_아닌_숫자는_예외_발생(String input) {
        assertThatThrownBy(() -> CycleInputValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-3"})
    void validate_자연수가_아닌_정수는_예외_발생(String input) {
        assertThatThrownBy(() -> CycleInputValidator.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
