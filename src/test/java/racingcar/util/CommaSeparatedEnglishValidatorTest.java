package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommaSeparatedEnglishValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "Hello,World123", "abc,한글", "Hello, World", "apple,orange ", "apple, orange"})
    void validateEnglishWithCommaToFail(String input) {
        assertThatThrownBy(() -> CommaSeparatedEnglishValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "Hello,World", "A,B,C,D"})
    void validateEnglishWithCommaToSuccess(String input) {
        assertDoesNotThrow(() -> CommaSeparatedEnglishValidator.validate(input));
    }
}
