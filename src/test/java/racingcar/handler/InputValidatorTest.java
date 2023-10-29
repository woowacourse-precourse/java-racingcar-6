package racingcar.handler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
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
    public void 자동차_이름은_공백을_포함하면_제거하고_5글자를_판단한다() {
        final String carName = "abcde ,a b c d e, abc d e, abc     de";
        inputValidator.validateCarName(carName);
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
    @Test
    public void 숫자_입력이_1보다_작은_경우_예외_발생() {
        assertThatThrownBy(() -> inputValidator.validateNumericInput("0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_RANGE_ERROR.getMessage());
    }
}
