package racingcar.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class GameCountValidatorTest {

    GameCountValidator gameCountValidator = new GameCountValidator();

    @Test
    void 입력값이_빈칸이라면_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> gameCountValidator.validateGameCount(""));
    }

    @Test
    void 입력값이_자연수가_아니라면_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> gameCountValidator.validateGameCount("0"));
    }
}