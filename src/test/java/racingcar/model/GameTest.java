package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void move() {
        int randomNum = 3;
        Game game = new Game(randomNum);
        assertThat(game.move()).isEqualTo(false);
    }
}