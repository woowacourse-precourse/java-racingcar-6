package racingcar.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRoundNumberInputExceptionTest {
    private UserRoundNumberInputException userRoundNumberInputException;
    @BeforeEach
    void setUp(){
        userRoundNumberInputException = new UserRoundNumberInputException();
    }
    private static final String IS_NOT_NUMBER_MESSAGE = "숫자만 입력해주세요";
    private static final String IS_BLANK_MESSAGE = "공백을 입력하시면 안됩니다.";
    private static final String IS_NOT_ZERO_OR_MINUS = "0이나 음수값을 입력하시면 안됩니다.";

    @Test
    void 입력_값_으로_숫자가_아닌_것(){
        String input = "가나다";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserRoundNumberInputException.isNumber(input));
        assertEquals(IS_NOT_NUMBER_MESSAGE, exception.getMessage());
    }

    @Test
    void 입력_값이_공백(){
        String input = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserRoundNumberInputException.isBlank(input));
        assertEquals(IS_BLANK_MESSAGE, exception.getMessage());
    }

    @Test
    void 입력_값이_0_또는_음수() {
        String input = "0";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> UserRoundNumberInputException.isZeroMinus(input));
        assertEquals(IS_NOT_ZERO_OR_MINUS, exception.getMessage());

    }


}