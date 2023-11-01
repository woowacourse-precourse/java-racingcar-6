package racingcar.validationTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.validation.TryCountInputValidator;

public class TryCountInputValidatorTest {
    private static final String ZERO_COUNT = "0";
    private static final String NON_DIGIT = "abc";

    private TryCountInputValidator tryCountInputValidator;

    @BeforeEach
    void setUp() {
        tryCountInputValidator = new TryCountInputValidator();
    }

    @Test
    void testValidateInputTryCountWithZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            tryCountInputValidator.validateInputTryCount(ZERO_COUNT);
        });
    }

    @Test
    void testValidateInputTryCountWithNonDigit() {
        assertThrows(IllegalArgumentException.class, () -> {
            tryCountInputValidator.validateInputTryCount(NON_DIGIT);
        });
    }
}