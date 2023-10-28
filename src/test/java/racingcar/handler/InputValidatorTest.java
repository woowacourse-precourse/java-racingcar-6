package racingcar.handler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    public void 자동차_이름이_비어있는_경우_예외_발생() {
        assertThatThrownBy(() -> inputValidator.validateCarName(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(EMPTY_STRING_ERROR.getMessage());
    }

    @Test
    public void 자동차_이름이_5글자_초과인_경우_예외_발생() {
        assertThatThrownBy(() -> inputValidator.validateCarName("abcdef"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_LENGTH_ERROR.getMessage());
    }

    @Test
    public void 숫자가_아닌_값을_입력하는_경우_예외_발생() {
        assertThatThrownBy(() -> inputValidator.validateNumericInput("abc"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NON_NUMERIC_ERROR.getMessage());
    }

    @Test
    public void 숫자_입력이_비어있는_경우_예외_발생() {
        assertThatThrownBy(() -> inputValidator.validateNumericInput(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(EMPTY_STRING_ERROR.getMessage());
    }
}
