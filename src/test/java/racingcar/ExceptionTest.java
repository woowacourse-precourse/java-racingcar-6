package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.exception.NumberException;


import static org.junit.jupiter.api.Assertions.*;


class ExceptionTest {

    @Test
    public void testValidateNumberValid() {
        // 유효한 숫자 문자열을 입력하고 예외가 발생하지 않는지 확인
        assertDoesNotThrow(() -> NumberException.validateNumber("123"));
    }

    @Test
    public void testValidateNumberInvalid() {
        // 유효하지 않은 문자열을 입력하고 NumberFormatException이 발생하는지 확인
        assertThrows(NumberFormatException.class, () -> NumberException.validateNumber("abc"));
    }

    @Test
    public void testIsNumberValid() {
        // 유효한 숫자 문자열을 입력하고 isNumber 메서드가 true를 반환하는지 확인
        assertTrue(NumberException.isNumber("456"));
    }

    @Test
    public void testIsNumberInvalid() {
        // 유효하지 않은 문자열을 입력하고 isNumber 메서드가 false를 반환하는지 확인
        assertFalse(NumberException.isNumber("xyz"));
    }
}
