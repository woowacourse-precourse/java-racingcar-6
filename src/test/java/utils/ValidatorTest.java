package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void isCarNameValidInputTest() {
        String carNameInput = "a,b,c";
        boolean result = Validator.isCarNameValid(carNameInput);
        assertThat(result).isTrue();
    }


    @Test
    void isCarNameInvalidInputTest() {
        String carNameInput = "a, 5자이상입력";
        boolean result = Validator.isCarNameValid(carNameInput);
        assertThat(result).isFalse();
    }

    @Test
    void isTryCountNumberValidInputTest() {
        String tryCountInput = "1";
        boolean result = Validator.isTryCountNumberValid(tryCountInput);
        assertThat(result).isTrue();
    }

    @Test
    void isTryCountNumberInvalidInputTest() {
        String tryCountInput = "-1";
        boolean result = Validator.isTryCountNumberValid(tryCountInput);
        assertThat(result).isFalse();
    }
}
