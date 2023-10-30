package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    void 문자열_형식오류_예외발생_테스트() {
        String invalidInput = "@@$";
        assertThatThrownBy(() -> {
            InputValidator.validateString(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차이름_5자이하_테스트() {
        String validInput = "pbi";
        boolean isValid = InputValidator.validateCarName(validInput);
        assertTrue(isValid);
    }

    @Test
    void 차이름_오류_예외발생_테스트() {
        String invalidInput = "pobisportscar";
        boolean isValid = InputValidator.validateCarName(invalidInput);
        assertThatThrownBy(() -> {
            InputValidator.validateString(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 시도입력_유효_테스트() {
        String validInput = "5";
        InputValidator validator = new InputValidator();
        boolean isValid = validator. validateRounds(validInput);
        assertTrue(isValid);
    }

    @Test
    public void 시도입력_형식오류_예외발생_테스트() {
        String invalidInput = "ㅇ";
        InputValidator validator = new InputValidator();
        assertThatThrownBy(() -> {
            InputValidator.validateString(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 시도입력_음수_예외발생_테스트() {
        String invalidInput = "ㅇ";
        assertThatThrownBy(() -> {
            InputValidator.validateString(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
