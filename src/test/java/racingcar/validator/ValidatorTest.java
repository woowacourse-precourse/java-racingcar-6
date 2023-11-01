package racingcar.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.constant.Constants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void validateCarName() {
        assertThatThrownBy(() -> validator.validateCarName("overfive"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_INVALID_CAR_NAME);
    }

    @Test
    void isCarNameInvalid() {
        assertThat(validator.isCarNameInvalid("test")).isFalse();
        assertThat(validator.isCarNameInvalid("overfive")).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"  ,", "\n,", ","})
    void validateInput(String input) {
        assertThatThrownBy(() -> validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_INVALID_CAR_NAME);
    }

}