package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    @Test
    public void makeRandomNumberTest() {
        Game game = new Game();
        int randomNumber = game.makeRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }
}
