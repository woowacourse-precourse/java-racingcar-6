package racingcar.common.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrialCountValidatorTest {

    @Test
    public void 시도회수_정상() {
        Assertions.assertDoesNotThrow(() -> TrialCountValidator.validate(3));
    }

    @Test
    public void 시도회수가_0번이거나_음수인_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TrialCountValidator.validate(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> TrialCountValidator.validate(-1));
    }

    @Test
    public void 시도회수가_INTEGER범위_초과한_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TrialCountValidator.validate(Integer.MAX_VALUE));
    }
}
