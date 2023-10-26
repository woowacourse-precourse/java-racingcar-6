package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    @ParameterizedTest
    @DisplayName("빈값 입력 예외 테스트")
    @ValueSource(strings = {"", " ", "  ", "   "})
    void invalidInputsTest1(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isEmpty(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_VALUE);
    }

    @ParameterizedTest
    @DisplayName("이름 6자 이상 입력 예외 테스트")
    @ValueSource(strings = {"gildong", "홍2동1동길", "monster", " d wd d2w w  "})
    void invalidInputsTest2(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isLengthLessThanFive(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }
}