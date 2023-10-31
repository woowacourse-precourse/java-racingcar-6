package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void 자동차_이름_저장() {
        Game game = new Game();
        String[] carNames = {"이규빈", "삼규빈", "사규빈"};
        game.save(carNames);
        for (int i = 0; i < game.cars.size(); i++) {
            Assertions.assertThat(game.cars.get(i).name).isEqualTo(carNames[i]);
        }
    }
}