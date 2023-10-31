package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    public void 쉼표_입력_기준이_틀렸을_경우_IllegalArgumentException을_발생시키는_기능() {
        InputValidator inputValidator = new InputValidator();
        String input = ",ABC,BBB,,";
        Assertions.assertThatThrownBy(() -> {
            inputValidator.setRacingCars(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}