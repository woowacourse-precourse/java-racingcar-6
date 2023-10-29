package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.BlankValidator;

public class BlankValidatorTest {
    BlankValidator blankValidator = new BlankValidator();

    @DisplayName("공백 검증기 - 정상입력")
    @Test
    void checkNotEmpty() {
        String name = "car";
        assertDoesNotThrow(() -> blankValidator.isEmpty(name));
    }

    @DisplayName("공백 검증기 - 빈값 입력시 예외 발생")
    @Test
    void checkNullInput() {
        String name = "";
        assertThrows(IllegalArgumentException.class, () -> blankValidator.isEmpty(name));
    }

    @DisplayName("공백 검증기 - 띄어쓰기 입력시 예외 발생")
    @Test
    void checkSpaceInput() {
        String name = " ";
        assertThrows(IllegalArgumentException.class, () -> blankValidator.isEmpty(name));
    }

}
