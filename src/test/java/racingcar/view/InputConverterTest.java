package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputConverterTest {

    @DisplayName("Input 값이 숫자일 경우 숫자로 변환")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void convertToIntegerWithValidNumbers(String input) {
        int result = InputConverter.convertToInteger(input);
        assertEquals(Integer.parseInt(input), result);
    }

    @DisplayName("Input 값이 문자일 경우 예외 체크")
    @ParameterizedTest
    @ValueSource(strings = {"a", "n", "@", " "})
    void convertToIntegerWithInvalidValues(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputConverter.convertToInteger(input));
    }
}
