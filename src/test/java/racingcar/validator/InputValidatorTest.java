package racingcar.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Test
    @DisplayName("자동차 이름이 콤마로 구분되어 있지 않으면 예외가 발생한다.")
    void InputValidatorTest1() {
        InputValidator validator = new InputValidator();
        String input = "pobi.asdf.qert";

        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateIsSplitByComma(input));
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닌 경우 예외가 발생한다.")
    void InputValidatorTest2() {
        InputValidator validator = new InputValidator();
        String input = "a";

        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateIsDigit(input));
    }

}