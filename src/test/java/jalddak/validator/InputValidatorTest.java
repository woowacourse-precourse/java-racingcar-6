package jalddak.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.validator.ErrorMessage.BLANK;
import static racingcar.validator.ErrorMessage.DUPLICATE;
import static racingcar.validator.ErrorMessage.EXCEED_MAX_LEN_OF_CAR_NAME;
import static racingcar.validator.ErrorMessage.LESS_THAN_MIN_NUM_OF_CAR;
import static racingcar.validator.ErrorMessage.LESS_THAN_MIN_NUM_OF_MATCHES;
import static racingcar.validator.ErrorMessage.NOT_INTEGER;
import static racingcar.validator.InputValidator.validateDuplicateName;
import static racingcar.validator.InputValidator.validateLenOfCar;
import static racingcar.validator.InputValidator.validateLenOfCarName;
import static racingcar.validator.InputValidator.validateName;
import static racingcar.validator.InputValidator.validateRangeOfMatches;
import static racingcar.validator.InputValidator.validateStringToInteger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {",,,,,a,,,", "a,     ,     ,", "a,,,,", ",a", "a,"})
    void 에외테스트_validateName(String given) {
        assertThatThrownBy(() -> validateName(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BLANK.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d,e,a", "a,a,a"})
    void 예외테스트_validateDuplicateName(String given) {
        assertThatThrownBy(() -> validateDuplicateName(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"b", "a", ""})
    void 예외테스트_validateLenOfCar(String given) {
        assertThatThrownBy(() -> validateLenOfCar(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LESS_THAN_MIN_NUM_OF_CAR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"basdasd", "     s", "s     "})
    void 예외테스트_validateLenOfCarName(String given) {
        assertThatThrownBy(() -> validateLenOfCarName(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEED_MAX_LEN_OF_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "asd", "31asd", "2147483648"})
    void 예외테스트_validateStringToInteger(String given) {
        assertThatThrownBy(() -> validateStringToInteger(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_INTEGER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    void 예외테스트_validateRangeOfMatches(String given) {
        assertThatThrownBy(() -> validateRangeOfMatches(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LESS_THAN_MIN_NUM_OF_MATCHES.getMessage());
    }
}
