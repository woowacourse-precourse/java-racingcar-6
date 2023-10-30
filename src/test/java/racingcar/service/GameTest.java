package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

    private Game game;
    @BeforeEach
    void setUp(){
        game = new Game();
    }

    @Test
    void moveForwardAttempt_전진성공() {
        assertThat(game.moveForwardAttempt(4)).isTrue();
    }

    @Test
    void moveForwardAttempt_전진실패(){
        assertThat(game.moveForwardAttempt(0)).isFalse();
    }
}