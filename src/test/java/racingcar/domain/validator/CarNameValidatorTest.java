package racingcar.domain.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.validator.exception.CarNameException;

public class CarNameValidatorTest {

    private CarNameValidator carNameValidator;

    @BeforeEach
    void setup() {
        carNameValidator = new CarNameValidator();
    }

    @Test
    void testCarNameValidatorWithValidInput() {
        Assertions.assertDoesNotThrow(() -> carNameValidator.validate("Car1,Car2,Car3"));
    }

    @Test
    void testCarNameValidatorWithEmptyInput() {
        String emptyInput = "";

        IllegalArgumentException emptyInputException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> carNameValidator.validate(emptyInput));

        Assertions.assertEquals(
                CarNameException.NO_VALUE_NAME.getMessage(),
                emptyInputException.getMessage()
        );
    }

    @Test
    void testCarNameValidatorWithTooLongName() {
        String tooLongName = "LongNamingIsNotValidatedInThisGame";

        IllegalArgumentException tooLongNameException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> carNameValidator.validate(tooLongName));

        Assertions.assertEquals(
                CarNameException.INVALID_TOO_LONG_NAME.getMessage(),
                tooLongNameException.getMessage()
        );
    }

    @Test
    void testCarNameValidatorWithTooShortName() {
        String tooShortName = "C";

        IllegalArgumentException tooShortNameException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> carNameValidator.validate(tooShortName)
        );

        Assertions.assertEquals(
                CarNameException.INVALID_TOO_SHORT_NAME.getMessage(),
                tooShortNameException.getMessage()
        );
    }
}