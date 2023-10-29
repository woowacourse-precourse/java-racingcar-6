package study;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import racingcar.exception.RacingException;
import org.junit.jupiter.api.Test;

public class ExceptionTest {
    RacingException racingException = new RacingException();

    @Test
    public void 콤마가_연속으로_입력() {
        // given
        String inputStr = "포비,,수현";

        // when , then
        assertThatThrownBy(() -> racingException.validateCommaAfterComma(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
