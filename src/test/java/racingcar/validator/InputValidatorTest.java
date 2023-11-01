package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    private InputValidator inputValidator = new InputValidator();

    @Test
    public void 자연수를_입력할_경우_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> inputValidator.validateTryCount("3"));
    }

    @Test
    public void 음수를_입력할_경우_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateTryCount("-1"));
    }

    @Test
    public void 문자열을_입력할_경우_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateTryCount("abc"));
    }

    @Test
    public void 공백을_입력할_경우_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateTryCount(""));
    }
}
