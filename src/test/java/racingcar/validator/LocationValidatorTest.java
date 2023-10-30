package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocationValidatorTest {

    private final BasicValidator<Integer> locationValidator = new LocationValidator();

    @Test
    void validate() {
        Throwable isNaturalNumberException = assertThrows(
                IllegalArgumentException.class,
                () -> locationValidator.validate(-1)
        );
        assertEquals("자연수가 아닙니다.", isNaturalNumberException.getMessage());

        assertDoesNotThrow(
                () -> locationValidator.validate(0)
        );
    }
}