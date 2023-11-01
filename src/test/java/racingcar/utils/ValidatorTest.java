package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {


    @Test
    @DisplayName("공백일 때 예외를 던지는지 테스트")
    void testCheckNameInputBlank() {
        assertThatThrownBy(() -> Validator.checkNameInput(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.BLANK_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("중복된 이름이 있을 때 예외를 던지는지 테스트")
    void testCheckNameInputDuplicateNames() {
        assertThatThrownBy(() -> Validator.checkNameInput("car,car"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.DUPLICATE_NAME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("n5자를 초과하는 이름이 있을 때 예외를 던지는지 테스트")
    void testCheckNameInputTooLongName() {
        assertThatThrownBy(() -> Validator.checkNameInput("longname"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.NAME_LENGTH_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("이름이 1개만 있을 때 예외를 던지는지 테스트")
    void testCheckNameInputTooFewNames() {
        assertThatThrownBy(() -> Validator.checkNameInput("car"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.MINIMUM_NUMBER_INPUTS_MESSAGE);
    }

    @Test
    @DisplayName("null일 때 예외를 던지는지 테스트")
    void testCheckAttemptsCountNull() {
        assertThatThrownBy(() -> Validator.checkAttemptsCount(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.NULL_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("숫자가 아닐 때 예외를 던지는지 테스트")
    void testCheckAttemptsCountNonNumeric() {
        assertThatThrownBy(() -> Validator.checkAttemptsCount("not a number"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.NOT_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("0 또는 음수일 때메서드가 예외를 던지는지 테스트")
    void testCheckAttemptsCountNonPositive() {
        assertThatThrownBy(() -> Validator.checkAttemptsCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.NOT_POSITIVE_NUMBER_ERROR_MESSAGE);

        assertThatThrownBy(() -> Validator.checkAttemptsCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.NOT_POSITIVE_NUMBER_ERROR_MESSAGE);
    }
}
