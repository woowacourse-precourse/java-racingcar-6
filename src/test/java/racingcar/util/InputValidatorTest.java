package racingcar.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private final InputValidator testInputValidator = Validator.generateInputValidator();
    @Test
    @DisplayName("이름 입력 예외 발생 테스트")
    void isValidList() {
        List<String> invalidList = Arrays.asList("a", "b", "U-keun");

        assertThrows(IllegalArgumentException.class, () -> {
            testInputValidator.isValidList(invalidList);
        });

        List<String> validList = Arrays.asList("hi", "I'm", "ukeun");

        assertDoesNotThrow(() -> {
            testInputValidator.isValidList(validList);
        });
    }

    @Test
    @DisplayName("숫자 입력 예외 발생 테스트")
    void isNumber() {
        String invalidCount = "12af";

        assertThrows(IllegalArgumentException.class, () -> {
            testInputValidator.isNumber(invalidCount);
        });

        String validCount = "34";

        assertDoesNotThrow(() -> {
            testInputValidator.isNumber(validCount);
        });
    }
}