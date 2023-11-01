package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void 게임이_정상적으로_실행() {
        String carNames = "Car1,Car2,Car3";
        Game game = new Game(carNames);
        Cars cars = game.getCars();
        assertNotNull(cars);
    }

    @Test
    public void 우승자를_하나_이상_반환() {
        String carNames = "Car1,Car2,Car3";
        Game game = new Game(carNames);
        game.playRound();
        List<String> winners = game.findWinners();
        assertNotNull(winners);
        assertThat(winners.size()).isGreaterThan(1);
    }
}