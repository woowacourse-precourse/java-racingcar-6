package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameValidatorTest {

    @Test
    void validateCarName() {
        String input ="one,two,three1";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validateCarNames(input);
        });
        String[] carName = CarNameValidator.validateCarNames(input);

    }
}