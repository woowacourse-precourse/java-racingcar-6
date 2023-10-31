package racingcar.utils.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoWhitespaceValidatorTest {

    @Test
    public void givenStringWithoutWhitespace_whenValidated_thenTrue() {
        assertTrue(NoWhitespaceValidator.validate("NoWhitespace"));
    }

    @Test
    public void givenStringWithWhitespace_whenValidated_thenFalse() {
        assertFalse(NoWhitespaceValidator.validate("With Whitespace"));
    }
}
