package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    public void 입력값이_빈_값인_경우() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isNullOrIsEmpty(null));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isNullOrIsEmpty(""));
        InputValidator.isNullOrIsEmpty("pobi");
    }

    @Test
    public void 쉼표_외_숫자나_기호가_있는_경우() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.includeNumberOrSymbolExceptComma("*"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.includeNumberOrSymbolExceptComma("123"));
        InputValidator.includeNumberOrSymbolExceptComma("pobi, woni");
    }

    @Test
    public void 공백이_포함된_경우() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.includeSpace("pobi, woni"));
        InputValidator.includeSpace("pobi,woni");
    }

    @Test
    public void 숫자가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isNotDigit("입력값"));
        InputValidator.isNotDigit("5");
    }
}
