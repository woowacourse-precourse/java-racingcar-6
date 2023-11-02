package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AttemptsTest {
    private Attempts attempts;
    private final String inputNumber = "5";
    @BeforeEach
    @Test
    void init() {
        attempts = new Attempts(inputNumber);
    }
    @Test
    void getNumber() { assertThat(attempts.getNumber()).isEqualTo(Integer.parseInt(inputNumber));
    }

    @Test
    void constructorNumberTest() {
        Attempts attempts = new Attempts(5);
        assertThat(attempts.getNumber() == 5).isTrue();
    }
    @Test
    void constructorNotNumericTest() {
        assertThatThrownBy(() -> new Attempts("isaac")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructorBlankTest() {
        assertThatThrownBy(() -> new Attempts("   ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructorNegativeTest() {
        assertThatThrownBy(() -> new Attempts("-1")).isInstanceOf(IllegalArgumentException.class);
    }
}