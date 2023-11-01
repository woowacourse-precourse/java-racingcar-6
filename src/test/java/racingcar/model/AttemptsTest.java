package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AttemptsTest {

    private Attempts attempts;
    private final String inputNumber = "5";
    @BeforeEach
    @Test
    void init() {
        attempts = new Attempts(inputNumber);
    }
    @Test
    void getNumber() {
        assertThat(attempts.getNumber()).isEqualTo(Integer.parseInt(inputNumber));
    }
}