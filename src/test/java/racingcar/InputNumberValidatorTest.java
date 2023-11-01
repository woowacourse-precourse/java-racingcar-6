package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;
import racingcar.exception.RacingCarException;
import racingcar.validator.InputNumberValidator;

public class InputNumberValidatorTest {
    @Test
    @DisplayName("::음수를 입력할 경우 예외가 발생한다")
    void negativeException_throwException_IfInputIsNegative() {
        Integer negativeNumber = -5;

        RacingCarException exception = assertThrows(RacingCarException.class, () ->
                InputNumberValidator.validateInputNumber(negativeNumber));
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.NEGATIVE_VALUE.getMessage());
    }

    @Test
    @DisplayName("::양수를 입력할 경우 예외가 발생하지 않는다")
    void checkException_throwNoException_IfInputIsPositive() {
        Integer positiveNumber = 3;

        assertDoesNotThrow(() -> InputNumberValidator.validateInputNumber(positiveNumber));
    }

    @Test
    @DisplayName("::0을 입력할 경우 예외가 발생한다")
    void ExceptionTest_WhenGivenZero_ThrowException() {
        Integer zero = 0;

        RacingCarException exception = assertThrows(RacingCarException.class, () ->
                InputNumberValidator.validateInputNumber(zero));
        assertThat(exception.getMessage()).isEqualTo(ErrorMessage.NEGATIVE_VALUE.getMessage());
    }
}
