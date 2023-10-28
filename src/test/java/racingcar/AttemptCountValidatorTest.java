package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.model.AttemptCountValidator;

public class AttemptCountValidatorTest {

    @Test
    void 입력값이_숫자가_아닐_경우_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            AttemptCountValidator.validateIsNumber("abc");
        });
    }

    @Test
    void 입력값이_양의_자연수가_아닐_경우_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            AttemptCountValidator.validateIsPositive(-1);
        });
    }

    @Test
    void 입력값이_빈값일_경우_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            AttemptCountValidator.validateNoEmpty("");
        });
    }

    @Test
    void 입력값이_null일_경우_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            AttemptCountValidator.validateNoEmpty(null);
        });
    }
}
