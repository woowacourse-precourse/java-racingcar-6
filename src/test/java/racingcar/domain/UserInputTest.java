package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    @Test
    void carName() {
        String input = "pobi,woni";
        assertThat(input).isEqualTo("pobi,woni");
    }

    @Test
    void attemptCount() {
        int input = 3;
        assertThat(input).isEqualTo(input);
    }

    @Test
    void processException() {
    }
}