package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarGame;

public class GenerationNumberTest {

    @Test
    void 정수_생성_범위() {
        int number = RacingCarGame.generateNumber();
        assertThat(number).isBetween(1, 9);
    }

    @Test
    void 일정_숫자_이상인지_판별_확인() {
        int bigNumber = 5;
        boolean bigNumberResult = RacingCarGame.checkNumberIs4Over(bigNumber);

        int smallNumber = 2;
        boolean smallNumberResult = RacingCarGame.checkNumberIs4Over(smallNumber);

        assertTrue(bigNumberResult);
        assertFalse(smallNumberResult);
    }
}
