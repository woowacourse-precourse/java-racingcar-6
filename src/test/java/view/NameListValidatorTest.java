package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import constants.ExceptionMessage;
import org.junit.jupiter.api.Test;

class NameListValidatorTest {
    static final NameListValidator nameListValidator = new NameListValidator();

    @Test
    public void 빈_값을_입력하면_예외발생(){
        String input = "";
        assertThatThrownBy(() -> nameListValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EMPTY_INPUT);
    }

    @Test
    public void 쉼표로_끝나면_예외발생(){
        String input = "aa,bb,";
        assertThatThrownBy(() -> nameListValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ENDS_WITH_COMMA);
    }
}