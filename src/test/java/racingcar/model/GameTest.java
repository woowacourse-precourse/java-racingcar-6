package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void testSetNumberOfAttempts() {
        game.setNumberOfAttempts(5);
        assertEquals(5, game.getNumberOfAttempts());
    }

    @Test
    void testAddCars() {
        // given when
        game.addCars("car1,car2,car3");

        // then
        assertThat(game.getNumberOfCars()).isEqualTo(3);
    }

    @Test
    void testGetWinnersResult() {
        // given
        game.setNumberOfAttempts(5);
        game.addCars("jisoo");
        game.startRound();
        game.findWinners();

        // when
        String result = game.getWinnersResult();

        // then
        assertThat(result).isEqualTo("최종 우승자 : jisoo");
    }

    @Test
    void testFindWinners() {
        // given
        game.setNumberOfAttempts(5);
        game.addCars("jisoo");
        game.startRound();

        // when
        game.findWinners();

        // then
        assertTrue(game.checkIsSoloWinner());
    }
}
