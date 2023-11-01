package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveCountInputValidationTest {

    private final MoveCountInputValidation moveCountInputValidation = new MoveCountInputValidation();

    @Test
    @DisplayName("움직일 횟수 입력값이 숫자인가?")
    public void isNumberTest() {
        assertThatThrownBy(() -> moveCountInputValidation.isNumber("숫자아님"))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("움직일 횟수의 입력값이 숫자가 아닙니다.");
    }

    @Test
    @DisplayName("움질일 횟수 입력값 공백 테스트")
    public void isNotBlankTest() {
        assertThatThrownBy(() -> moveCountInputValidation.isNumber(""))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("움직일 횟수의 입력값이 숫자가 아닙니다.");
    }

}
