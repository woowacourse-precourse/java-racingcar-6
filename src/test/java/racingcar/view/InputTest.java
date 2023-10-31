package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {

    @Test
    @DisplayName("입력값이 빈 문자열이면 예외 발생")
    void validateInputBlank_exceptionTest() {
        assertThatCode(() -> new InputView().validateInputBlank(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력값이 빈 문자열이 아니면 정상 종료")
    @ValueSource(strings = {"name1", "Alice,Bob,John"})
    void validateInputBlank_normalTest(String input) {
        assertThatCode((() -> new InputView().validateInputBlank(input)))
                .doesNotThrowAnyException();
    }
}
