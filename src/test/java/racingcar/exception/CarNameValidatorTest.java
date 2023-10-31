package racingcar.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarNameValidatorTest {
    @Test
    @DisplayName("자동차 이름이 null일때 예외처리 발생")
    void shouldThrowExceptionWhenCarNameIsNull() {
        assertThatThrownBy(() -> CarNameValidator.validate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름의 길이가 5보다 클 때 예외처리 발생")
    void shouldThrowExceptionWhenCarNameIsLongerThanFive() {
        assertThatThrownBy(() -> CarNameValidator.validate("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름의 길이가 1보다 작을 때 예외처리 발생")
    void shouldThrowExceptionWhenCarNameIsEmpty() {
        assertThatThrownBy(() -> CarNameValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}