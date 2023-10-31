package racingcar.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class UserRoundNumberInputExceptionTest {
    private UserRoundNumberInputException userRoundNumberInputException;

    private static final String IS_NOT_NUMBER_MESSAGE = "숫자만 입력해주세요";
    private static final String IS_BLANK_MESSAGE = "공백을 입력하시면 안됩니다.";
    private static final String IS_NOT_ZERO_OR_MINUS = "0이나 음수값을 입력하시면 안됩니다.";
    private String input = "abc";
    @BeforeEach
    void setUp(){
        userRoundNumberInputException = new UserRoundNumberInputException(input);
    }
    @Test
    void 라운드_입력이_숫자가_아닐_경우(){
        assertThrows(IllegalArgumentException.class, () -> new UserRoundNumberInputException(input));
    }

    @Test
    void 라운드_입력이_공백일_경우(){
        assertThrows(IllegalArgumentException.class, () -> new UserRoundNumberInputException(input));
    }

    @Test
    void 라운드_입력이_음수_혹은_0_(){
        assertThrows(IllegalArgumentException.class, () -> new UserRoundNumberInputException(input));
    }
}