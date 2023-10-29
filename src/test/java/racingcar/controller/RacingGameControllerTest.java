package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

public class RacingGameControllerTest {

    @Test
    void 우승자_선정_단독 () {
        //given
        List<String> carName = new ArrayList<>();
        carName.add("car1");
        carName.add("car2");
        Game game = new Game(carName, 1);

        Car[] cars = game.getCars();

        cars[0].goForward();
        List<String> expectedWinner = new ArrayList<>();
        expectedWinner.add("car1");

        //when
        RacingGameController rc = new RacingGameController();
        List<String> winner = rc.winners(game);

        //then
        Assertions.assertThat(winner).isEqualTo(expectedWinner);
    }

    @Test
    void 우승자_선정_공동() {
        //given
        List<String> carName = new ArrayList<>();
        carName.add("car1");
        carName.add("car2");
        Game game = new Game(carName, 1);

        Car[] cars = game.getCars();

        cars[0].goForward();
        cars[1].goForward();

        List<String> expectedWinner = new ArrayList<>();
        expectedWinner.add("car1");
        expectedWinner.add("car2");

        //when
        RacingGameController rc = new RacingGameController();
        List<String> winner = rc.winners(game);

        //then
        Assertions.assertThat(winner).isEqualTo(expectedWinner);
    }
}
