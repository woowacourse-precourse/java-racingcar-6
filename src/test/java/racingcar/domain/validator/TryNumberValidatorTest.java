package racingcar.domain.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.validator.exception.TryNumberException;

public class TryNumberValidatorTest {
    private TryNumberValidator tryNumberValidator;

    @BeforeEach
    void setup() {
        tryNumberValidator = new TryNumberValidator();
    }

    @Test
    void testTryNumberValidatorWithValidInput() {
        Assertions.assertDoesNotThrow(() -> tryNumberValidator.validate("5"));
    }

    @Test
    void testTryNumberValidatorWithEmptyInput() {
        String emptyInput = "";

        IllegalArgumentException emptyInputException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> tryNumberValidator.validate(emptyInput)
        );

        Assertions.assertEquals(
                TryNumberException.NO_VALUE_TRY_NUMBER.getMessage(),
                emptyInputException.getMessage()
        );
    }

    @Test
    void testTryNumberValidatorWithNonNumericInput() {
        String nonNumericInput = "abc";

        IllegalArgumentException nonNumericException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> tryNumberValidator.validate(nonNumericInput)
        );

        Assertions.assertEquals(
                TryNumberException.INVALID_INTEGER_VALUE.getMessage(),
                nonNumericException.getMessage()
        );
    }

    @Test
    void testTryNumberValidatorWithTooBigInput() {
        String tooBigInput = "11";

        IllegalArgumentException tooBigNumberException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> tryNumberValidator.validate(tooBigInput)
        );

        Assertions.assertEquals(
                TryNumberException.INVALID_TOO_BIG_TRY_NUMBER.getMessage(),
                tooBigNumberException.getMessage()
        );
    }

    @Test
    void testTryNumberValidatorWithTooSmallInput() {
        String tooSmallInput = "0";

        IllegalArgumentException tooSmallNumberException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> tryNumberValidator.validate(tooSmallInput)
        );

        Assertions.assertEquals(
                TryNumberException.INVALID_TOO_SMALL_TRY_NUMBER.getMessage(),
                tooSmallNumberException.getMessage()
        );
    }
}
