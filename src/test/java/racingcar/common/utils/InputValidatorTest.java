package racingcar.common.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.common.consts.SystemMessage;

class InputValidatorTest {
    @Test
    void 입력한_숫자가_숫자가_아닌_경우_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class,()-> InputValidator.validateInputNumber("안녕"), SystemMessage.INVALID_INPUT_NUMBER_ERROR);
    }
    @Test
    void 입력한_숫자가_정상적인_경우(){
        String input="2";
        int n=InputValidator.validateInputNumber(input);
        assertEquals(2,n);
    }
    @Test
    void 입력한_이름이_MAX_NAME_SIZE를_넘긴경우_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class,()-> InputValidator.validateName("maxsize"), SystemMessage.INVALID_INPUT_NAME_ERROR);
    }

    @Test
    void 입력한_이름이_정상(){
        assertTrue(InputValidator.validateName("newbi"));
    }
}