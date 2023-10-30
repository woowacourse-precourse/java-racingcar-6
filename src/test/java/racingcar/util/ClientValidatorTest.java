package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ClientValidatorTest {

    @Test
    @DisplayName("한 자리 숫자를 멀쩡하게 입력하면 int형으로 잘 변환한다.")
    void getValidatedIntValue() {
        String inputtedNumber = "1";
        BigInteger value = ClientValidator.getValidatedBigIntegerValue(inputtedNumber);
        assertThat(value).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 아닌 다른 값을 입력하면 IllegalArgumentException 발생")
    void notNumberFormatException() {
        String inputtedNotNumberString = "한글";
        assertThatThrownBy(() -> ClientValidator.getValidatedBigIntegerValue(inputtedNotNumberString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자연수가 아닌 0이나 음수를 입력하면 IllegalArgumentException 발생")
    void notNaturalNumberException() {
        String inputtedZero = "0";
        String inputtedMinus = "-100";
        assertThatThrownBy(() -> ClientValidator.getValidatedBigIntegerValue(inputtedZero))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ClientValidator.getValidatedBigIntegerValue(inputtedMinus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}