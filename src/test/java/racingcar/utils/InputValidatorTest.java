package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("입력값 전처리 테스트 - Null 데이터 - 오류")
    void preprocessNullInputTest() {
        assertThatThrownBy(() -> inputValidator.preprocessInputString(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값 전처리 테스트 - 빈 문자열 데이터 - 오류")
    void preprocessEmptyInputTest() {
        assertThatThrownBy(() -> inputValidator.preprocessInputString(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값 전처리 테스트 - 공백 포함 데이터 - 성공")
    @ValueSource(strings = {"po bi"})
    @ParameterizedTest
    void preprocessSpacingInputTest(String names) {
        assertThat(inputValidator.preprocessInputString(names)).isEqualTo("pobi");
    }

    @DisplayName("입력값 전처리 테스트 - 공백/빈 문자열 포함 데이터 - 성공")
    @ValueSource(strings = {"po bi, "})
    @ParameterizedTest
    void preprocessSpacingWIthEmptyInputTest(String names) {
        assertThat(inputValidator.preprocessInputString(names)).isEqualTo("pobi,");
    }
}
