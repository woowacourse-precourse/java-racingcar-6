package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest {
    private UserInput userInput;
    private final String NAME_INPUT = "pobi,woni,jun";
    private final String COUNT_INPUT = "3";

    @BeforeEach
    void setUp() {
        userInput = new UserInput();
    }

    @Test
    void 자동차_이름_리스트() {
        List<String> result = userInput.carName(NAME_INPUT);
        assertThat(result).isEqualTo(Arrays.asList("pobi", "woni", "jun"));
    }

    @Test
    void 시도횟수() {
        int result = userInput.attemptCount(COUNT_INPUT);
        assertThat(result).isEqualTo(3);
    }
}