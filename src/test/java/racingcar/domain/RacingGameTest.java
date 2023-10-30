package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 라운드가_진행되면_현재_라운드가_1_증가한다() {
        RacingGame racingGame = new RacingGame(5, new Car("pobi"));
        racingGame.nextRound();
        assertEquals(1, racingGame.getCurrentRound());
    }
}