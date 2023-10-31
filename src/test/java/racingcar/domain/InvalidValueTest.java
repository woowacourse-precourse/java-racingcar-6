package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InvalidValueTest {
    private InvalidValue invalidValue;

    @BeforeEach
    void setUp() {
        invalidValue = new InvalidValue();
    }

    @Test
    void 입력값_5자_초과() {
        boolean result = invalidValue.isExceedFiveLetters(Arrays.asList("123456"));
        assertThat(result).isTrue();
    }

    @Test
    void 입력값_5자_이하() {
        boolean result = invalidValue.isExceedFiveLetters(Arrays.asList("12345"));
        assertThat(result).isFalse();
    }

    @Test
    void 입력값_자연수() {
        boolean result = invalidValue.isNaturalNumber("5");
        assertThat(result).isTrue();
    }

    @Test
    void 입력값_자연수_아닐_때() {
        boolean result = invalidValue.isNaturalNumber("five");
        assertThat(result).isFalse();
    }
}