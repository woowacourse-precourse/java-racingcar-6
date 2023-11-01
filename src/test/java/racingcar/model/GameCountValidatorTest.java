package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GameCountValidatorTest {

    @Test
    void 정상_작동_테스트() {
        String gameCount = "5";

        GameCountValidator.validateGameCount(gameCount);
    }

    @Test
    void 횟수가_숫자가_아니라면_예외발생() {
        String gameCount = "abc";

        assertThrows(IllegalArgumentException.class,
                () -> GameCountValidator.validateGameCount(gameCount));
    }

    @Test
    void 횟수가_1이상의_자연수가_아니라면_예외발생() {
        String gameCount = "-1";

        assertThrows(IllegalArgumentException.class,
                () -> GameCountValidator.validateGameCount(gameCount));
    }
}
