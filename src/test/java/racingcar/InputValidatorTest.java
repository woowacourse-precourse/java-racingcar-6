package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    void 이름_길이에_대한_예외_처리() {
        String validName = "sieun";
        String invalidName = "sieunnnn";

        assertDoesNotThrow(() -> inputValidator.lengthOfCarNameValidate(validName));
        assertThrows(IllegalArgumentException.class, () -> inputValidator.lengthOfCarNameValidate(invalidName));
    }

    @Test
    void 게임_횟수에_대한_예외_처리() {
        String validGameCount = "1";
        String invalidGameCount = "a";

        assertDoesNotThrow(() -> inputValidator.gameCountValidate(validGameCount));
        assertThrows(IllegalArgumentException.class, () -> inputValidator.gameCountValidate(invalidGameCount));
    }
}