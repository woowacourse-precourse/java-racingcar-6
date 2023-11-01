package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    void validateNameLengthNotOver_길이가짧을때_오류없음() {
        Assertions.assertDoesNotThrow(() -> Validation.validateNameLengthNotOver("TEST", 5));
    }
    @Test
    void validateNameLengthNotOver_길이가같을때_오류없음() {
        Assertions.assertDoesNotThrow(() -> Validation.validateNameLengthNotOver("TEST", 4));
    }

    @Test
    void validateNameLengthNotOver_길이가길때_오류발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateNameLengthNotOver("test", 3));
    }


    @Test
    void validateNotEmptyName_빈문자열체크_오류발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateNotEmptyName(""));
    }

    @Test
    void validateNotEmptyName_비지않은문자열체크_오류없음() {
        Assertions.assertDoesNotThrow(() -> Validation.validateNotEmptyName(" "));
    }


    @Test
    void validateIsNumber_문자열숫자체크_오류없음() {
        Assertions.assertDoesNotThrow(() -> Validation.validateIsNumber("123"));
    }

    @Test
    void validateIsNumber_문자열소수체크_오류발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateIsNumber("1.23"));
    }

    @Test
    void validateIsNumber_문자열문자체크_오류발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateIsNumber("abc"));
    }


    @Test
    void validateNaturalNumber_문자열자연수체크_오류없음() {
        Assertions.assertDoesNotThrow(() -> Validation.validateNaturalNumber(123));
    }

    @Test
    void validateNaturalNumber_문자열음수체크_오류발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateNaturalNumber(-123));
    }

    @Test
    void validateNaturalNumber_문자열0체크_오류발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateNaturalNumber(0));
    }
}
