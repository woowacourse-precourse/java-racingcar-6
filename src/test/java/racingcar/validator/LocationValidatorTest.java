package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocationValidatorTest {

    @Test
    void validate() {
        Throwable isNaturalNumberException = assertThrows(
                IllegalArgumentException.class,
                () -> new LocationValidator().validate(-1)
        );
        assertEquals("자연수가 아닙니다.", isNaturalNumberException.getMessage());

        assertDoesNotThrow(
                () -> new LocationValidator().validate(0)
        );
    }
}