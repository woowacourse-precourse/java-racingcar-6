package racingcar.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    CarNameValidator carNameValidator = new CarNameValidator();

    @Test
    void 자동차_이름이_5자를_초과할경우_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> carNameValidator.validateCarName(List.of("lovejava")));
    }

    @Test
    void 자동차_이름이_중복일경우_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> carNameValidator.validateCarName(List.of("nara", "nara")));
    }
}