package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GameTest {

    @Test
    void 이동_조건_정지_검사() {
        int randomNum = 3;
        Game game = new Game(randomNum);
        assertThat(game.move()).isEqualTo(false);
    }
    @Test
    void 이동_조건_이동_검사() {
        int randomNum = 5;
        Game game = new Game(randomNum);
        assertThat(game.move()).isEqualTo(true);
    }
}