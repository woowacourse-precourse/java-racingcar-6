package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputNumberTest {
    @Test
    public void testInputNumberEquals() {
        String testNumber = "5";
        InputNumber inputNumber = new InputNumber(testNumber);
        assertThat(inputNumber.isEquals(5)).isTrue();
    }

    @Test
    public void testInvalidStringInput() {
        String invalidNumber = "abc";
        assertThrows(IllegalArgumentException.class, () -> {
            new InputNumber(invalidNumber);
        });
    }

    @Test
    public void testNegativeInput() {
        String negativeNumber = "-5";
        assertThrows(IllegalArgumentException.class, () -> {
            new InputNumber(negativeNumber);
        });
    }
}
