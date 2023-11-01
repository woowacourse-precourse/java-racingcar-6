package racingcar.validate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryCountValidateTest {

    @Test
    void isInputNullTest() {

        assertThatThrownBy(() -> TryCountValidate.validateTryCount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수를 입력해주세요.");
    }

    @Test
    void isInputNumberTest() {

        assertThatThrownBy(() -> TryCountValidate.validateTryCount("백번"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해주세요.");
    }

    @Test
    void isInputNegativeTest() {

        assertThatThrownBy(() -> TryCountValidate.validateTryCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상의 숫자만 입력해주세요.");
    }
}
