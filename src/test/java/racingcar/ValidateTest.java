package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import validator.InputValidator;

public class ValidateTest {

    @Test
    void racingCarNameLengthTest() {
        String[] racingCarNames = {"mouse,rackets"};
        Assertions.assertThatThrownBy(() -> InputValidator.validateRacingCarNames(racingCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
