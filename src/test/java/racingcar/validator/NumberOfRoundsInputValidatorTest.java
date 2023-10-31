package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class NumberOfRoundsInputValidatorTest {

    private final BasicValidator<String> numberOfRoundsInputValidator = new NumberOfRoundsInputValidator();

    @Test
    void 게임_진행_횟수_검증() {
        assertThatThrownBy(
                () -> numberOfRoundsInputValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 없습니다.");

        assertThatThrownBy(
                () -> numberOfRoundsInputValidator.validate("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 0 이하의 숫자입니다.");

        assertThatThrownBy(
                () -> numberOfRoundsInputValidator.validate("1.1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 정수가 아닙니다.");

        assertThatThrownBy(
                () -> numberOfRoundsInputValidator.validate("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 정수가 아닙니다.");

        assertDoesNotThrow(
                () -> numberOfRoundsInputValidator.validate("1")
        );
    }
}