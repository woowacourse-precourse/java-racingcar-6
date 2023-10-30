package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.consts.ErrorMessages;
import racingcar.util.InputValidator;

public class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("자동차 이름 입력에 중복이 있는 경우")
    void testValidateCarNames1() {
        List<String> carNames = Arrays.asList("car1", "car1", "car2");

        assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.DUPLICATION_CAR_NAME_MESSAGE.get());
    }

    @Test
    @DisplayName("자동차 종류가 2가지 이상이 아닐 경우")
    void testValidateCarNames2() {
        List<String> carNames = Arrays.asList("car1");

        assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.WRONG_CAR_TYPES_MESSAGE.get());
    }

    @Test
    @DisplayName("자동차 이름이 1글자 이상 5글자 이하가 아닌 경우")
    void testValidateCarNames3() {
        List<String> carNames1 = Arrays.asList("carNamesExample", "car1", "car2");
        List<String> carNames2 = Arrays.asList("", "car1", "car2");

        assertThatThrownBy(() -> inputValidator.validateCarNames(carNames1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.WRONG_CAR_NAME_LENGTH_MESSAGE.get());
        assertThatThrownBy(() -> inputValidator.validateCarNames(carNames2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.WRONG_CAR_NAME_LENGTH_MESSAGE.get());
    }
}
