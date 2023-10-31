package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class AttemptNumTest {

    @Test
    void isValid() {
        AttemptNum attemptNum = new AttemptNum();
        assertThatThrownBy(() -> attemptNum.isValid("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}