package racingcar.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.validator.InputValidator;
import racingcar.util.validator.Validator;

class InputValidatorTest {
    private final InputValidator testInputValidator = (InputValidator) Validator.generateInputValidator();
    @Test
    @DisplayName("이름 입력 예외 발생 테스트")
    void isValidList() {
        List<String> invalidList1 = Arrays.asList("a", "b", "U-keun");

        assertThrows(IllegalArgumentException.class, () -> {
            testInputValidator.isValidList(invalidList1);
        });

        List<String> invalidList2 = Arrays.asList("", "aa");

        assertThrows(IllegalArgumentException.class, () -> {
            testInputValidator.isValidList(invalidList2);
        });

        List<String> invalidList3 = Arrays.asList("ukeun", "ukeun");

        assertThrows(IllegalArgumentException.class, () -> {
            testInputValidator.isValidList(invalidList3);
        });

        List<String> validList = Arrays.asList("hi", "I'm", "ukeun");

        assertDoesNotThrow(() -> {
            testInputValidator.isValidList(validList);
        });
    }

    @Test
    @DisplayName("숫자 입력 예외 발생 테스트")
    void isNumber() {
        String invalidCount1 = "";

        assertThrows(IllegalArgumentException.class, () -> {
            testInputValidator.isPositiveInteger(invalidCount1);
        });

        String invalidCount2 = "12af";

        assertThrows(IllegalArgumentException.class, () -> {
            testInputValidator.isPositiveInteger(invalidCount2);
        });

        String invalidCount3 = "-34";

        assertThrows(IllegalArgumentException.class, () -> {
            testInputValidator.isPositiveInteger(invalidCount3);
        });

        String validCount = "34";

        assertDoesNotThrow(() -> {
            testInputValidator.isPositiveInteger(validCount);
        });
    }
}