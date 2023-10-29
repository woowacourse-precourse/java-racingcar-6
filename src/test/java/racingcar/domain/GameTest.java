package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class GameTest {

    private Game game;

    @Test
    void 모든_자동차가_전진_확인() {
        game = new Game("pobi,woni,jun", new TestNumberGenerator(7));
        game.playOneRound();
        assertThat(game.getCars()).allMatch(car -> car.getMoveNum() == 1);
    }

    @Test
    void 모든_자동차가_멈춤_확인() {
        game = new Game("pobi,woni,jun", new TestNumberGenerator(3));
        game.playOneRound();
        assertThat(game.getCars()).allMatch(car -> car.getMoveNum() == 0);
    }

    @Test
    void 우숭자_자동차_리스트_조회하는_테스트() {
        game = new Game("pobi,woni,jun", new TestNumberGenerator(7));
        List<String> winners = game.getWinners();
        assertThat(winners).containsExactly("pobi", "woni", "jun");
    }
}
