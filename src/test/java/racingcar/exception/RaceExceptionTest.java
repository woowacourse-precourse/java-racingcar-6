package racingcar.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class RaceExceptionTest {
    @Test
    void shouldThrowExceptionWhenCarNameIsNull() {
        assertThatThrownBy(() -> RaceException.validateCarName(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldThrowExceptionWhenCarNameIsLongerThanFive() {
        assertThatThrownBy(() -> RaceException.validateCarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldThrowExceptionWhenCarNameIsEmpty() {
        assertThatThrownBy(() -> RaceException.validateCarName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}