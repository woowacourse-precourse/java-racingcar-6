package validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import message.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    @DisplayName("자동차 이름은 5자 이하만 가능하다")
    @Test
    void validateCarNameLength() {
        String[] carNames = {"abcdef", "ghi", "jkl"};

        assertThatThrownBy(() -> CarNameValidator.validateCarNameLength(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NAME_LENGTH_ERROR);

    }

    @DisplayName("자동차 이름에 중복이 있으면 안된다.")
    @Test
    void validateCarNameDuplicate() {
        String[] carNames = {"abc", "def", "abc"};

        assertThatThrownBy(() -> CarNameValidator.validateCarNameDuplicate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NAME_DUPLICATE_ERROR);
    }
}