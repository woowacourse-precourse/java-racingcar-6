package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DigitsOnlyValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "123abc", "123한글", "12.34", "123 ", " 123", "1,000"})
    void validateDigitsOnlyToFail(String input) {
        assertThatThrownBy(() -> DigitsOnlyValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "123", "001"})
    void validateDigitsOnlyToSuccess(String input) {
        assertDoesNotThrow(() -> DigitsOnlyValidator.validate(input));
    }
}
