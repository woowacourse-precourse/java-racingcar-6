package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void 게임_객체를_생성() {
        Game game = new Game(3,5);

        int carCount = game.getCarsCount();
        int roundCount = game.getRoundCount();

        assertAll(
                ()-> assertEquals(3,carCount),
                () -> assertEquals(5,roundCount)
        );
    }
}
