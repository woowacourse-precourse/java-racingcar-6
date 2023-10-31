package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    void test_isBlank() {
        String input="";
        assertThat(InputValidator.isBlank(input)).isEqualTo(true);
    }

    @Test
    void test_isNumber() {
        String input="5";
        assertThat(InputValidator.isNumber(input)).isEqualTo(true);
    }

    @Test
    void test_checkZero() {
        String input="5";
        assertThat(InputValidator.checkZero(input)).isEqualTo(false);
    }

    @Test
    void test_singleInput() {
        String input="car";
        assertThat(InputValidator.singleInput(input)).isEqualTo(true);
    }

    @Test
    void test_checkNameLength() {
        String[] input = "car1,car2333".split(",");
        assertThat(InputValidator.checkNameLength(input)).isEqualTo(true);
    }

    @Test
    void test_carNameValidator() {
        String input="car,car555";
        assertThatThrownBy(() -> InputValidator.carNameValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_tryCountValidator() {
        String input=" ";
        assertThatThrownBy(() -> InputValidator.tryCountValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}