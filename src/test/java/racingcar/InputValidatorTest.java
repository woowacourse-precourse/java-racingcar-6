package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.InputValidator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {

    private InputValidator inputValidator = new InputValidator();

    @Test
    void nameLengthOver5Test() {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidator.validateLength("abcdef"));
    }

    @Test
    void nameLengthUnder5Test() {
        assertDoesNotThrow(() ->
                inputValidator.validateLength("abc"));
    }

    @Test
    void 정수가_아닌경우_예외가_발생합니다() {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidator.convertToValidInteger("a"));
    }

    @Test
    void 정수가_입력될_경우_예외가_발생하지_않습니다() {
        assertDoesNotThrow(() ->
                inputValidator.convertToValidInteger("4"));
    }

    @Test
    void zero을_입력할_경우_예외가_발생합니다() {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidator.validatePlayCountIsPositive(0));
    }

    @Test
    void 음수를_입력할_경우_예외가_발생합니다() {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidator.validatePlayCountIsPositive(-3));
    }

    @Test
    void 양수를_입력할_경우_예외가_발생하지_않습니다() {
        assertDoesNotThrow(() ->
                inputValidator.validatePlayCountIsPositive(3));
    }


}
