package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setup() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @DisplayName("쉼표 기준으로 구분된 문자열이 아니면 예외 발생")
    @ValueSource(strings = {"aaabbbccc", "qq.ee.rrr", "kk|ddd|fff"})
    void should_Throw_Exception_For_Invalid_Comma_Separated_String(String input) {
        // when
        // then
        assertThatThrownBy(() -> inputValidator.validateInputFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Err.INVALID_CAR_NAMES_FORMAT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("콤마로 문자열이 구분되었으나 공백 포함이거나 빈 문자열은 예외 발생")
    @ValueSource(strings = {"", " "})
    void should_Throw_Exception_For_Empty_String(String input) {
        // when
        // then
        assertThatThrownBy(() -> inputValidator.validateNonEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Err.NON_EMPTY_STRING.getMessage());
    }

    @ParameterizedTest
    @DisplayName("시도 횟수가 숫자 문자열로 입력되지 않으면 예외 발생")
    @ValueSource(strings = {"a", "bb", "!", "$#", "1q@"})
    void should_Throw_Exception_For_Invalid_Numeric_Input(String input) {
        // when
        // then
        assertThatThrownBy(() -> inputValidator.validateNumericString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Err.NUMERIC_STRING_ONLY.getMessage());
    }
}