package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.Validator.NumberValidator;

public class NumberTest {

    @Test
    void check_readCorrectInput() {
        // BUILD
        String validNumberInput = "5";
        // OPERATION
        NumberValidator.validateIsNumberic(validNumberInput);
        int parsedNumber = Integer.parseInt(validNumberInput);
        // CHECK
        assertThat(parsedNumber).isEqualTo(5);
    }

    @Test
    void check_ifInputIsNotNumeric() {
        // BUILD
        String invalidNumberInput = "abc";
        // OPERATION , CHECK
        assertThatThrownBy(() -> NumberValidator.validateIsNumberic(invalidNumberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_NegativeInput() {
        // BUILD
        String negativeNumberInput = "-5";
        // OPERATION , CHECK
        assertThatThrownBy(() -> NumberValidator.validateIsInRange(negativeNumberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_zeroInput() {
        // BUILD
        String zeroInput = "0";
        // OPERATION, CHECK
        assertThatThrownBy(() -> NumberValidator.validateIsInRange(zeroInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

