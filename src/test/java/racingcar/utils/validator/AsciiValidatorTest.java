package racingcar.utils.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsciiValidatorTest {
    @Test
    public void givenValidAsciiString_whenValidated_thenTrue() {
        assertTrue(AsciiValidator.validate("ValidASCII"));
    }

    @Test
    public void givenInvalidAsciiString_whenValidated_thenFalse() {
        assertFalse(AsciiValidator.validate("Invalid©ASCII"));
    }

    @Test
    public void givenBoundaryValues_whenValidated_thenTrue() {
        assertTrue(AsciiValidator.validate(String.valueOf((char) 32)));
        assertTrue(AsciiValidator.validate(String.valueOf((char) 127)));
    }

    @Test
    public void givenBoundaryValues_whenValidated_thenFalse() {
        assertFalse(AsciiValidator.validate(String.valueOf((char) 31)));
        assertFalse(AsciiValidator.validate(String.valueOf((char) 128)));
    }
}