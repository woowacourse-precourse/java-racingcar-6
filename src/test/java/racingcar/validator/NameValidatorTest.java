package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class NameValidatorTest {

    private final BasicValidator<String> nameValidator = new NameValidator();

    @Test
    void 자동차_이름_검증() {
        assertThatThrownBy(() -> nameValidator.validate("a!@#$%^&*"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에는 특수문자가 포함될 수 없습니다.");

        assertThatThrownBy(() -> nameValidator.validate("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");

        assertThatThrownBy(() -> nameValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");

        assertDoesNotThrow(
                () -> nameValidator.validate("a")
        );
    }
}