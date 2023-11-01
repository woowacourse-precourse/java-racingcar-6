package racingcar.validate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateNumberTest {

    @Test
    void 전진_횟수_예외_처리() {
        //given
        final Long forwardCount = -1L;

        //then
        Assertions.assertThatThrownBy(() -> ValidateNumber.validateForwardCount(forwardCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
