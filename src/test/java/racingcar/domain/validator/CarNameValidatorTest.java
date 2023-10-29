package racingcar.domain.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.validator.exception.CarNameException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

        assertThatThrownBy(() -> carNameValidator.validate(emptyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CarNameException.NO_VALUE_NAME.getMessage());
    }

    @Test
    void 차_이름_너무_긴_입력_검증예외() {
        String tooLongName = "LongNamingIsNotValidatedInThisGame";

        assertThatThrownBy(() -> carNameValidator.validate(tooLongName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CarNameException.INVALID_TOO_LONG_NAME.getMessage());
    }

    @Test
    void 차_이름_너무_짧은_입력_검증예외() {
        String tooShortName = "C";

        assertThatThrownBy(() -> carNameValidator.validate(tooShortName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CarNameException.INVALID_TOO_SHORT_NAME.getMessage());
    }
}