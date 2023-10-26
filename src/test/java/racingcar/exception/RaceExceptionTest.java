package racingcar.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


class RaceExceptionTest {
    @Test
    void shouldThrowExceptionWhenCarNameIsNull() {
        assertThatThrownBy(() -> RaceException.validateCarName(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}