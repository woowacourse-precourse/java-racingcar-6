package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class CarNamesInputValidatorTest {

    private final BasicValidator<String> carNamesInputValidator = new CarNamesInputValidator();

    @Test
    void validate() {
        assertThatThrownBy(() -> carNamesInputValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 없습니다.");

        assertThatThrownBy(() -> carNamesInputValidator.validate(",a,b,c,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 쉼표로 시작하거나 끝날 수 없습니다.");

        assertThatThrownBy(() -> carNamesInputValidator.validate("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 2개 이상이어야 합니다.");

        assertThatThrownBy(() -> carNamesInputValidator.validate("a,b,a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");

        assertThatThrownBy(() -> carNamesInputValidator.validate("a%,b@"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에는 특수문자가 포함될 수 없습니다.");

        assertThatThrownBy(() -> carNamesInputValidator.validate("abcdef,abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");

        assertDoesNotThrow(
                () -> carNamesInputValidator.validate("a,b,c")
        );
    }
}