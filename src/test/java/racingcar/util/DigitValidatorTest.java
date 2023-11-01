package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DigitValidatorTest {
    @Test
    void validateIsInteger_메소드로_입력_문자열이_정수인지_검증() {
        String integerString1 = "123";
        String integerString2 = "0123";
        String integerString3 = "안녕하세요";

        assertTrue(DigitValidator.isInteger(integerString1));
        assertFalse(DigitValidator.isInteger(integerString2));
        assertFalse(DigitValidator.isInteger(integerString3));
    }
}
