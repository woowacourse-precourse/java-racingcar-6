package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.validator.InputValidator;

public class InputTest {
    @Test
    void validateCarsFormat_자동차이름이_쉼표로구분되지않은경우_예외() {
        String input1 = "pobi.woni jun";
        String input2 = "p";
        String input3 = "pobi,woni,jun";

        assertThatThrownBy(() -> InputValidator.validateCarsFormat(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(input2).isEqualTo("p");
        assertThat(input3).contains("pobi", "woni", "jun");
    }

    @Test
    void validateCarLength_자동차이름이_6자이상인경우_예외() {
        assertThatThrownBy(() -> InputValidator.validateCarLength("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
