package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.TestNumberGenerator;

class WinnerFinderTest {

    @Test
    void 우승자_이름_찾기() {
        List<Car> carList = Arrays.asList(
                new Car("pobi", new TestNumberGenerator(1)),
                new Car("woni", new TestNumberGenerator(7)),
                new Car("jun", new TestNumberGenerator(9))
        );
        Game game = new Game(carList);
        game.playOneRound();
        List<String> winners = WinnerFinder.findWinners(game.getCars()); // woni, jun
        assertThat(winners).containsOnly("woni", "jun");
    }
}
