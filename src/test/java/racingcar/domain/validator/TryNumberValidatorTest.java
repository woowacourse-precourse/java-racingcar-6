package racingcar.domain.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.validator.exception.TryNumberException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryNumberValidatorTest {
    private TryNumberValidator tryNumberValidator;

    @BeforeEach
    void setup() {
        tryNumberValidator = new TryNumberValidator();
    }

    @Test
    void 시도_회수_입력_검증성공() {
        String collectInput = "2";
        Assertions.assertDoesNotThrow(() -> tryNumberValidator.validate(collectInput));
    }

    @Test
    void 시도_회수_빈_입력_검증예외() {
        String emptyInput = "";

        assertThatThrownBy(() -> tryNumberValidator.validate(emptyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TryNumberException.NO_VALUE_TRY_NUMBER.getMessage());
    }

    @Test
    void 시도_회수_숫자_아닌_입력_검증예외() {
        String nonNumericInput = "abc";

        assertThatThrownBy(() -> tryNumberValidator.validate(nonNumericInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TryNumberException.INVALID_INTEGER_VALUE.getMessage());
    }

    @Test
    void 시도_회수_너무_큰_입력_검증예외() {
        String tooBigInput = "11";

        assertThatThrownBy(() -> tryNumberValidator.validate(tooBigInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TryNumberException.INVALID_TOO_BIG_TRY_NUMBER.getMessage());
    }

    @Test
    void 시도_회수_너무_작은_입력_검증예외() {
        String tooSmallInput = "0";

        assertThatThrownBy(() -> tryNumberValidator.validate(tooSmallInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TryNumberException.INVALID_TOO_SMALL_TRY_NUMBER.getMessage());
    }
}
