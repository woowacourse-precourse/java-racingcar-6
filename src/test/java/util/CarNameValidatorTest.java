package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameValidatorTest {

    @Test
    public void 유효한_차이름_입력() {
        String validCarName = "Tesla";

        assertDoesNotThrow(() -> CarNameValidator.checkValidCarName(validCarName));
    }

    @Test
    public void 유효하지않은_차이름_입력_예외발생() {
        String invalidCarName = "Ford Mustang";
        assertThrows(IllegalArgumentException.class, () -> CarNameValidator.checkValidCarName(invalidCarName));
    }

    @Test
    public void 조건보다_긴_차이름_입력_예외발생() {
        String invalidCarName = "MercedesBenz";
        assertThrows(IllegalArgumentException.class, () -> CarNameValidator.checkValidCarName(invalidCarName));
    }
}
