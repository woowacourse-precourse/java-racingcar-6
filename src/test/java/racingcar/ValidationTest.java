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
}
