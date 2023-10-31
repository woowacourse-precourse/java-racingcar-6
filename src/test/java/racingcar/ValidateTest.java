package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateTest {

    @Test
    @DisplayName("차 이름의 길이가 5자 이하이면 검증을 통과한다.")
    void carNameValidationPasses_WhenCarNameLengthIsLessThanOrEqualTo5() {
        String[] carNames = {"car1", "car2", "car3"};

        assertThatCode(() -> Validate.carNames(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("차 이름의 길이가 5자를 초과하면 예외가 발생한다")
    void ThrowException_WhenCarNameLengthExceeds5Characters() {
        String[] carNames = {"car1", "car2", "car3","exceptionCar"};

        assertThatThrownBy(() -> Validate.carNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 문자열이 숫자가 아니라 예외가 발생한다")
    void throwException_WhenInputStringIsNotNumber() {
        String inputExceptionNumber = "가";

        assertThatThrownBy(() -> Validate.number(inputExceptionNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 문자열이 숫자타입이면 검증을 통과한다")
    void passValidation_WhenInputStringIsANumber() {
        String inputNumber = "5";

        assertThatCode(() -> Validate.number(inputNumber))
                .doesNotThrowAnyException();
    }
}