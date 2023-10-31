package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.global.message.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @Test
    void isInputValid_null_예외_발생(){
        String userInput = null;

        assertThatThrownBy(() -> InputValidator.isInputValid(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_IS_INVALID.getMessage());
    }

    @Test
    void isInputValid_빈_문자열_예외_발생(){
        String userInput = "";

        assertThatThrownBy(() -> InputValidator.isInputValid(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_IS_INVALID.getMessage());
    }

    @Test
    void isInputValid_공백_예외_발생(){
        String userInput = " ";

        assertThatThrownBy(() -> InputValidator.isInputValid(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_IS_INVALID.getMessage());
    }

    @Test
    void isInputDigit_숫자_이외_입력_예외_발생(){
        String userInput = "nonDigit";

        assertThatThrownBy(() -> InputValidator.isInputDigit(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
    }
}
