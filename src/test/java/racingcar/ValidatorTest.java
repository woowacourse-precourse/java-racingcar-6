package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    Validator validator;

    @BeforeEach
    void setup() {
        validator = new Validator();
    }

    @Test
    @DisplayName("")
    void validateGameRoundSuccess() {
        String stringNumber = "5";
        assertEquals(5, validator.validateGameRound(stringNumber));
    }

    @Test
    @DisplayName("")
    void validateGameRoundFail() {
        assertThrows(IllegalArgumentException.class, () ->
                validator.validateGameRound("test"));
    }
}