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
    void 차_이름_입력_검증성공() {
        Assertions.assertDoesNotThrow(() -> carNameValidator.validate("Car1,Car2,Car3"));
    }

    @Test
    void 차_이름_없는_입력_검증예외() {
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
    void 차_이름_너무_긴_입력_검증예외() {
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
    void 차_이름_너무_짧은_입력_검증예외() {
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