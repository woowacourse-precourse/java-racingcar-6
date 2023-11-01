package racingcar;

import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    @Test
    void 레이싱_게임_테스트() {
        // given
        final String input = "pobi,woni,jun\n15";
        RacingGame racingGame = new RacingGame();

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        Assertions.assertThatCode(racingGame::run).doesNotThrowAnyException();
    }

    @Test
    void 레이싱_게임_예외_테스트() {
        // given
        final String input = "pobi,woni,ju n\na";
        RacingGame racingGame = new RacingGame();

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        Assertions.assertThatThrownBy(racingGame::run)
                .isInstanceOf(IllegalArgumentException.class);
    }
}