package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class InputValidationTest {


    @Test
    public void CarName_입력_X() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidation.validateCarNameLength(""); // Short name should throw an exception
        });
    }

    @Test
    public void CarName_길이_초과() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidation.validateCarNameLength("hwanvely"); // Long name should throw an exception
        });
    }


    @Test
    public void 정수외입력시() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidation.validateCount("invalid"); // Invalid input should throw an exception
        });
    }
}
