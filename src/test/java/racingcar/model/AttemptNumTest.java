package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AttemptNumTest {

    @Test
    void validateAttemptNum() {
        AttemptNum attemptNum = new AttemptNum();
        assertThatThrownBy(() -> attemptNum.isValid("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}