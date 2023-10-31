package view;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import constants.ExceptionMessage;
import org.junit.jupiter.api.Test;
import validator.AttemptTimesValidator;

class AttemptTimesValidatorTest {

    static final AttemptTimesValidator attemptTimesValidator = new AttemptTimesValidator();

    @Test
    public void validate_양의_정수_입력하면_정상작동() {
        String input = "3";
        boolean isExceptionExist = false;
        try {
            attemptTimesValidator.validate(input);
        } catch (Exception e) {
            isExceptionExist = true;
        }
        assertThat(isExceptionExist).isFalse();
    }

    @Test
    public void validate_아무것도_입력하지_않으면_예외발생() {
        String input = "";
        assertThatThrownBy(() -> attemptTimesValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_INTEGER);
    }

    @Test
    public void validate_문자열을_입력하면_예외발생() {
        String input = "가나다";
        assertThatThrownBy(() -> attemptTimesValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_INTEGER);
    }

    @Test
    public void validate_음수를_입력하면_예외발생() {
        String input = "-10";
        assertThatThrownBy(() -> attemptTimesValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_PLUS);
    }
}