package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatNoException;

class ClientValidatorTest {

    @Test
    @DisplayName("한 자리 숫자를 멀쩡하게 입력하면 int형으로 잘 변환한다.")
    void getValidatedIntValue() {
        String inputtedNumber = "1";
        long value = ClientValidator.getValidatedIntValue(inputtedNumber);
        assertThat(value).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 아닌 다른 값을 입력하면 IllegalArgumentException 발생")
    void notNumberFormatException() {
        String inputtedNotNumberString = "한글";
        assertThatThrownBy(() -> ClientValidator.getValidatedIntValue(inputtedNotNumberString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자연수가 아닌 0이나 음수를 입력하면 IllegalArgumentException 발생")
    void notNaturalNumberException() {
        String inputtedZero = "0";
        String inputtedMinus = "-100";
        assertThatThrownBy(() -> ClientValidator.getValidatedIntValue(inputtedZero))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ClientValidator.getValidatedIntValue(inputtedMinus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("int 범위를 벗어나는 숫자를 입력해도 IllegalArgumentException 발생")
    void cannotCastToInt() {
        String inputtedTooBigNumber = "2147483648";
        assertThatThrownBy(() -> ClientValidator.getValidatedIntValue(inputtedTooBigNumber))
                .isInstanceOf(IllegalArgumentException.class);

        String inputtedTooSmallNumber = "-2147483649";
        assertThatThrownBy(() -> ClientValidator.getValidatedIntValue(inputtedTooSmallNumber))
                .isInstanceOf(IllegalArgumentException.class);

        String inputtedInRangeOfInt = "2147483647";
        assertThatNoException().isThrownBy(() ->
                ClientValidator.getValidatedIntValue(inputtedInRangeOfInt));
    }
}