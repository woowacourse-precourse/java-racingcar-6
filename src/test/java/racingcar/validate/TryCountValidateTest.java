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
}