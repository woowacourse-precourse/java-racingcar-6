package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class GameTest {

    @Test
    void 게임_시작() {
        Game game = new Game(new String[]{"pobi", "woni", "jun"});
        game.start();
    }

    @Test
    void 게임_우승자_확인() {
        Game game = new Game(new String[]{"pobi", "woni", "jun"});
        game.start();
        List<Car> winners = game.getWinners();
        assertThat(winners).isNotEmpty();
    }
}