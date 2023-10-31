package racingcar.common.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.common.consts.SystemMessage;

class InputValidatorTest {
    @Test
    void 입력한_숫자가_숫자가_아닌_경우_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInputNumber("안녕"),
                SystemMessage.INVALID_INPUT_NUMBER_ERROR);
    }

    @Test
    void 입력한_숫자가_정상적인_경우() {
        String input = "2";
        int n = InputValidator.validateInputNumber(input);
        assertEquals(2, n);
    }

}