package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import constants.ExceptionMessage;
import org.junit.jupiter.api.Test;

class NameListValidatorTest {
    static final NameListValidator nameListValidator = new NameListValidator();

    @Test
    public void 빈_값을_입력했는지_검증(){
        String input = "";
        assertThatThrownBy(() -> nameListValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EMPTY_INPUT);
    }

}