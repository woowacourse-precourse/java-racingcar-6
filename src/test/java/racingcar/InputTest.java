package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.validator.InputValidator;

public class InputTest {
    @Test
    void validateCarsFormat_자동차이름_올바른형식아니면_예외() {
        String input_ok1 = "p";
        String input_ok2 = "pobi,woni,jun";

        String input_notok1 = "pobi.woni.jun";
        String input_notok2 = "pobi     , woni,   jun";
        String input_notok3 = ",pobi,jun";
        String input_notok4 = "pobi,woni,jun,";

        assertThatThrownBy(() -> InputValidator.validateCarsFormat(input_notok1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateCarsFormat(input_notok2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateCarsFormat(input_notok3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateCarsFormat(input_notok4))
                .isInstanceOf(IllegalArgumentException.class);
       assertThat(input_ok1).isEqualTo("p");
       assertThat(input_ok2).contains("pobi", "woni", "jun");
    }

    @Test
    void validateCarLength_자동차이름_6자이상이거나_공백이면_예외() {
        assertThatThrownBy(() -> InputValidator.validateCarNameValid(List.of("pobi","woooni","jun")))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateCarNameValid(List.of("pobi","","","jun")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateUniqueCarName_자동차이름_중복되면_예외() {
        assertThatThrownBy(() -> InputValidator.validateUniqueCarName(List.of("pobi","wooni","pobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateTryNumber_경주시도횟수_숫자가아니면_예외() {
        assertThatThrownBy(() -> InputValidator.validateTryNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
