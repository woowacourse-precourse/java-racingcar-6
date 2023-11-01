package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void isRunnable_ReturnsTrue_WhenRandomNumberIsGreaterThanOrEqualToFour() {
        String[] carArray = {"car1", "car2", "car3"};
        Game game = new Game(new Cars(carArray));

        assertTrue(game.isRunnable(4));
        assertTrue(game.isRunnable(5));
        assertTrue(game.isRunnable(9));
    }

    @Test
    public void isRunnable_ReturnsFalse_WhenRandomNumberIsLessThanFour() {
        String[] carArray = {"car1", "car2", "car3"};
        Game game = new Game(new Cars(carArray));
        
        assertFalse(game.isRunnable(0));
        assertFalse(game.isRunnable(1));
        assertFalse(game.isRunnable(3));
    }

}