package validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import message.ErrorMessages;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    @Test
    void 자동차_이름이_5자가_넘는_경우_예외발생() {
        String[] carNames = {"abcdef", "ghi", "jkl"};

        assertThatThrownBy(() -> CarNameValidator.validateCarNameLength(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NAME_LENGTH_ERROR);

    }

    @Test
    void 자동차_이름에_중복이_있는_경우_예외발생() {
        String[] carNames = {"abc", "def", "abc"};

        assertThatThrownBy(() -> CarNameValidator.validateCarNameDuplicate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NAME_DUPLICATE_ERROR);
    }
}