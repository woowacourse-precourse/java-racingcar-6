package racingcar.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class RaceExceptionTest {
    @Test
    void shouldThrowExceptionWhenCarNameIsNull() {
        assertThatThrownBy(() -> CarNameValidator.validate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldThrowExceptionWhenCarNameIsLongerThanFive() {
        assertThatThrownBy(() -> CarNameValidator.validate("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldThrowExceptionWhenCarNameIsEmpty() {
        assertThatThrownBy(() -> CarNameValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}