package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @Test
    public void 입력값이_빈_값인_경우() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isNullOrIsEmpty(null));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isNullOrIsEmpty(""));
        InputValidator.includeNumberOrSymbol("pobi");
    }

    @Test
    public void 쉼표_외_숫자나_기호가_있는_경우() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.includeNumberOrSymbol("*"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.includeNumberOrSymbol("123"));
        InputValidator.includeNumberOrSymbol("pobi, woni");
    }
}
