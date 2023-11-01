package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

public class GameServiceTest {
    GameService gameService = new GameService();

    @Test
    public void 우승자_판별() throws Exception {
        //given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        List<String> winnerNames = Arrays.asList("pobi");
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
        Game game = new Game(carList, 1);
        game.getcarList().get(0).moveForward();

        //when
        //then
        Assertions.assertThat(gameService.getWinner(game))
                .isEqualTo(winnerNames);
    }
}
