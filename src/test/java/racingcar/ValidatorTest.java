package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.Validator;

public class ValidatorTest {

    @Test
    void 비어있는_입력_예외테스트() {
        assertThatThrownBy(()-> Validator.validateEmpty(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input can't be empty.");
    }

    @Test
    @DisplayName("0이하의 수 입력 예외테스트")
    void 이하의_수_입력_예외테스트() {
        assertThatThrownBy(()-> Validator.validatePositive("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should be more than zero.");
    }

    @Test
    void 정수가_아닌_수_입력_예외테스트() {
        assertThatThrownBy(()-> Validator.validateInteger("1.34"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Input should be integer.");
    }
}
