package jalddak.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.validator.ErrorMessage.BLANK;
import static racingcar.validator.ErrorMessage.EXCEED_MAX_LEN_OF_CAR_NAME;
import static racingcar.validator.ErrorMessage.LESS_THAN_MIN_NUM_OF_CAR;
import static racingcar.validator.InputValidator.validateLenOfCar;
import static racingcar.validator.InputValidator.validateLenOfCarName;
import static racingcar.validator.InputValidator.validateName;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    void 에외테스트_validateName() {
        List<String> givenList = new ArrayList<>();
        givenList.add(",,,,,a,,,");
        givenList.add("a,     ,     ,");
//        givenList.add("a,,,,");

        for (String given : givenList) {
            assertThatThrownBy(() -> validateName(given))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(BLANK.getMessage());
        }

    }

    @Test
    void 예외테스트_validateLenOfCar() {
        List<String> givenList = new ArrayList<>();
        givenList.add("a,,,,");

        for (String given : givenList) {
            assertThatThrownBy(() -> validateLenOfCar(given))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(LESS_THAN_MIN_NUM_OF_CAR.getMessage());
        }
    }

    @Test
    void 예외테스트_validateLenOfCarName() {
        List<String> givenList = new ArrayList<>();
        givenList.add("a,b,c,asdasd,sd");

        for (String given : givenList) {
            assertThatThrownBy(() -> validateLenOfCarName(given))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(EXCEED_MAX_LEN_OF_CAR_NAME.getMessage());
        }
    }
}
