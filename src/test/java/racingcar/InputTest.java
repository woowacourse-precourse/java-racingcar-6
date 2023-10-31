package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class InputTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi.woni.jun", "pobi     , woni,   jun",",pobi,jun","pobi,woni,jun,"})
    void validateCarsFormat_자동차이름_올바른형식아니면_예외(String inputs) {
        assertThatThrownBy(() -> InputValidator.validateCarsFormat(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateCarLength_자동차이름_6자이상이거나_공백이면_예외() {
        assertThatThrownBy(() -> InputValidator.validateCarNameValid(List.of("pobi", "woooni", "jun")))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateCarNameValid(List.of("pobi", "", "", "jun")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateUniqueCarName_자동차이름_중복되면_예외() {
        assertThatThrownBy(() -> InputValidator.validateUniqueCarName(List.of("pobi", "wooni", "pobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateTryNumber_경주시도횟수_숫자가아니면_예외() {
        assertThatThrownBy(() -> InputValidator.validateTryNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
