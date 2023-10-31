package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 라운드가_진행되면_현재_라운드가_1_증가한다() {
        RacingGame racingGame = new RacingGame(5, List.of("a", "b", "c"));
        racingGame.nextRound();
        assertEquals(1, racingGame.getCurrentRound());
    }
}