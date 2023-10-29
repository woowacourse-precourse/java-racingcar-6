package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setup() {
        inputValidator = new InputValidator();
    }

    @DisplayName("쉼표 기준으로 구분된 문자열 검증 성공")
    @Test
    void should_Validate_Comma_Separated_String() {
        // given
        String input1 = "z,x,c,v";
        String input2 = "kim,lee,park";

        // when
        // then
        inputValidator.validateInputFormat(input1);
        inputValidator.validateInputFormat(input2);
    }

    @ParameterizedTest
    @DisplayName("콤마로 문자열이 구분되었으나 공백 포함이거나 빈 문자열은 예외 발생")
    @ValueSource(strings = {"", " "})
    void should_Throw_Exception_For_Empty_String(String input) {
        // when
        // then
        assertThatThrownBy(() -> inputValidator.validateNonEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 문자열은 빈 칸 또는 공백 문자를 포함하면 안됩니다.");
    }

    @ParameterizedTest
    @DisplayName("시도 횟수가 숫자 문자열로 입력되지 않으면 예외 발생")
    @ValueSource(strings = {"a", "bb", "!", "$#", "1q@"})
    void should_Throw_Exception_For_Invalid_Numeric_Input(String input) {
        // when
        // then
        assertThatThrownBy(() -> inputValidator.validateNumericString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1이상의 양수로 된 문자열만 입력할 수 있습니다.");
    }
}