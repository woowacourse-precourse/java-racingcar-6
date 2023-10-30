package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {
    private UserInput userInput;

    @BeforeEach
    void setUp() {
        userInput = new UserInput();
    }
    @Test
    void carName() {
        List<String> testInput = userInput.carName("pobi,woni");
        assertThat(testInput).containsExactly("pobi", "woni");
    }

    @Test
    void attemptCount() {
        int testInput = userInput.attemptCount("3");
        assertThat(testInput).isEqualTo(3);
    }

    @Test
    void processException() {
    }
}