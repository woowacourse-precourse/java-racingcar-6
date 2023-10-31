package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {

    @ValueSource(strings = {"pobi,javaji", "", "pobi,pobi", "다섯자초과한글이름"})
    @ParameterizedTest
    @DisplayName("이름 예외 처리 테스트: 비정상 입력")
    void testUnusualInputNameValue(String names) {
        assertThatThrownBy(() -> InputValidation.validateInputName(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"pobi,java", "pobi, java", "pobi,java,", "pobi", "123,456,789", " ,  ,   "})
    @ParameterizedTest
    @DisplayName("이름 예외 처리 테스트: 정상 입력")
    void testUsualInputNameValue(String names) {
        assertThatCode(() -> InputValidation.validateInputName(names))
                .doesNotThrowAnyException();
    }

    @ValueSource(strings = {"1번", " ", "-1", "2147483648"})
    @ParameterizedTest
    @DisplayName("시도 횟수 예외 처리 테스트: 비정상 입력")
    void testUnusualInputTryNumberValue(String numbers) {
        assertThatThrownBy(() -> InputValidation.validateInputNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"0", "1", "20", "2147483647"})
    @ParameterizedTest
    @DisplayName("시도 횟수 예외 처리 테스트: 정상 입력")
    void testUsualInputTryNumberValue(String numbers) {
        assertThatCode(() -> InputValidation.validateInputNumber(numbers))
                .doesNotThrowAnyException();
    }
}
