package jalddak.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.validator.ErrorMessage.EXCEED_MAX_LEN_OF_CAR_NAME;
import static racingcar.validator.ErrorMessage.LESS_THAN_MIN_NUM_OF_CAR;
import static racingcar.validator.InputValidator.validateCarList;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    void validateCarList_예외테스트_validateLenOfCar() {
        String given = "a,";

        assertThatThrownBy(() -> validateCarList(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LESS_THAN_MIN_NUM_OF_CAR.getMessage());
    }

    @Test
    void validateCarList_예외테스트_validateLenOfCarName() {
        String given = "a,b,casdsw,d,e";

        assertThatThrownBy(() -> validateCarList(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEED_MAX_LEN_OF_CAR_NAME.getMessage());
    }
}
