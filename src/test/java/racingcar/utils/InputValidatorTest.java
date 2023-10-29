package racingcar.utils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {

    @Test
    void testCheckIntegerWithValidInput() {
        String IntegerInput = "123";
        assertDoesNotThrow(() -> InputValidator.checkInteger(IntegerInput));
    }

    @Test
    void testCheckIntegerWithNonIntegerInput() {
        String nonIntegerInput = "abc";
        assertThatThrownBy(() -> InputValidator.checkInteger(nonIntegerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 값이 정수가 아닙니다.");
    }

    @Test
    void testCheckValidStringLengthWithValidInput() {
        String[] validLengthInput = {"Car1", "Car2", "Car3"};
        assertDoesNotThrow(() -> InputValidator.checkValidStringLength(validLengthInput));
    }

    @Test
    void testCheckValidStringLengthWithNullArray() {
        String[] nullArray = null;
        assertThatThrownBy(() -> InputValidator.checkValidStringLength(nullArray))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("값을 입력하여 주십시오.");
    }

    @Test
    void testCheckValidStringLengthWithShortString() {
        String[] shortString = {""};
        assertThatThrownBy(() -> InputValidator.checkValidStringLength(shortString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름의 길이는 1에서 5까지여야 합니다.");
    }

    @Test
    void testCheckValidStringLengthWithLongString() {
        String[] longString = {"Caaaar1", "Car2", "Car3"};
        assertThatThrownBy(() -> InputValidator.checkValidStringLength(longString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름의 길이는 1에서 5까지여야 합니다.");
    }
}
