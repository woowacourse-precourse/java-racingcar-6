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
    void tryMoveForward_전진성공() {
        assertThat(game.tryMoveForward(4)).isTrue();
    }

    @Test
    void tryMoveForward_전진실패(){
        assertThat(game.tryMoveForward(0)).isFalse();
    }
}