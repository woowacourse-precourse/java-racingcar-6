package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    @DisplayName("입력값이 빈 문자열이면 예외 발생, 그렇지 않으면 정상 종료")
    void validateInputBlank_ExceptionTest() {
        assertThatCode(() -> new InputView().validateInputBlank(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatCode((() -> new InputView().validateInputBlank("name1,name2,name3")))
                .doesNotThrowAnyException();
    }
}
