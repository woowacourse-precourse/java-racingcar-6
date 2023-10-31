package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    static String[] cars;
    static Game game;

    @BeforeEach
    void setup() {
        cars = new String[]{"hans", "jins"};
        game = new Game(cars, 3);
    }

    @Test
    public void Game_생성() {
        for (int i = 0; i < cars.length; i++) {
            assertThat(game.players[i].name).isEqualTo(cars[i]);
            assertThat(game.players[i].location).isEqualTo(0);
        }
    }

    @Test
    public void Game_play의_테스트() {
        game.play(game);
        for (int i = 0; i < cars.length; i++) {
            assertThat(game.players[i].location<=game.playNum).isTrue();
        }
    }
}