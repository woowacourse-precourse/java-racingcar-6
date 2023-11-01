package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.consts.ErrorMessages;
import racingcar.domain.InputValidator;

public class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("자동차 이름 입력에 중복이 있는 경우")
    void testValidateCarNames1() {
        String playerInput = "car1,car1,car3";

        assertThatThrownBy(() -> inputValidator.validateCarNames(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.DUPLICATION_CAR_NAME_MESSAGE.get());
    }

    @Test
    @DisplayName("자동차 종류가 2가지 이상이 아닐 경우")
    void testValidateCarNames2() {
        String playerInput = "car1";

        assertThatThrownBy(() -> inputValidator.validateCarNames(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.WRONG_CAR_TYPES_MESSAGE.get());
    }

    @Test
    @DisplayName("자동차 이름이 1글자 이상 5글자 이하가 아닌 경우")
    void testValidateCarNames3() {
        String playerInput1 = "carNamesExample,car1";
        String playerInput2 = ",car1,car2";

        assertThatThrownBy(() -> inputValidator.validateCarNames(playerInput1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.WRONG_CAR_NAME_LENGTH_MESSAGE.get());
        assertThatThrownBy(() -> inputValidator.validateCarNames(playerInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.WRONG_CAR_NAME_LENGTH_MESSAGE.get());
    }

    @Test
    @DisplayName("시행 횟수 입력이 정수형태가 아닌 경우")
    void testValidateNumberOfAttempt1() {
        String playerInput1 = "숫자아닌입력";
        String playerInput2 = "0012";

        assertThatThrownBy(() -> inputValidator.validateNumberOfAttempt(playerInput1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.WRONG_NUMBER_OF_ATTEMPT_MESSAGE.get());
        assertThatThrownBy(() -> inputValidator.validateNumberOfAttempt(playerInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.WRONG_NUMBER_OF_ATTEMPT_MESSAGE.get());
    }

    @Test
    @DisplayName("시행 횟수가 1회 이상이 아닌 경우")
    void testValidateNumberOfAttempt2() {
        String playerInput = "0";

        assertThatThrownBy(() -> inputValidator.validateNumberOfAttempt(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.WRONG_NUMBER_OF_ATTEMPT_MESSAGE.get());
    }
}
