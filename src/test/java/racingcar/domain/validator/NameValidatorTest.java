package racingcar.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NameValidatorTest {
    @Test
    public void validate_maximumName_정상적인_입력() {
        int MAXIMUM_NAME = NameValidator.getMaximumName_ForTest();
        StringBuffer nameBuffer = new StringBuffer("a");
        for (int i = 0; i < MAXIMUM_NAME - 1; i++) {
            nameBuffer.append("a");
        }
        String name = nameBuffer.toString();

        NameValidator.validate(name);
    }

    @Test
    public void validate_maximumName_MAXIMUM_NAME_보다_크면_예외_발생() {
        int MAXIMUM_NAME = NameValidator.getMaximumName_ForTest();
        StringBuffer nameBuffer = new StringBuffer("a");
        for (int i = 0; i < MAXIMUM_NAME; i++) {
            nameBuffer.append("a");
        }
        String name = nameBuffer.toString();

        assertThatThrownBy(() -> NameValidator.validate(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The name must be less than " + (MAXIMUM_NAME + 1) + " characters.");
    }
}