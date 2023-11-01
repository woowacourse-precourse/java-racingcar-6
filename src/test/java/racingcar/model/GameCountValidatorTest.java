package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class GameCountValidatorTest {

    @Test
    void 정상_작동_테스트() {
        String gameCount = "5";

        assertThatCode(() -> GameCountValidator.validateGameCount(gameCount))
                .doesNotThrowAnyException();
    }

    @Test
    void 횟수가_숫자가_아니라면_예외발생() {
        String gameCount = "abc";

        assertThatThrownBy(() -> GameCountValidator.validateGameCount(gameCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수가_1이상의_자연수가_아니라면_예외발생() {
        String gameCount = "-1";

        assertThatThrownBy(() -> GameCountValidator.validateGameCount(gameCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
