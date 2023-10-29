package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Game;
import racingcar.domain.TestNumberGenerator;

class WinnerFinderTest {

    @Test
    void 우승자_이름_찾기() {
        Game game = new Game("pobi,woni,jun", new TestNumberGenerator(7));
        game.playOneRound();
        List<String> winners = WinnerFinder.findWinners(game.getCars()); // pobi, woni, jun
        assertThat(winners).containsOnly("pobi", "woni", "jun");
    }
}
