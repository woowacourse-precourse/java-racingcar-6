package racingcar.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CountExceptionTest {

    @Test
    void 글자_입력() {
        String number = "테스트";

        assertThatThrownBy(() -> CountException.validation(number))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CountException.validation(number))
                .hasMessage("숫자 1 이상 100 이하를 입력해 주세요.");
    }

    @Test
    void 숫자_0_입력() {
        String number = "0";

        assertThatThrownBy(() -> CountException.validation(number))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CountException.validation(number))
                .hasMessage("숫자 1 이상 100 이하를 입력해 주세요.");
    }

    @Test
    void 숫자_100_초과() {
        String number = "111404023923";

        assertThatThrownBy(() -> CountException.validation(number))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CountException.validation(number))
                .hasMessage("숫자 1 이상 100 이하를 입력해 주세요.");
    }
}