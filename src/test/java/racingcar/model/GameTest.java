package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void Game_생성시_초기화_성공() throws Exception {
        //given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        int roundNumber = 10;
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }

        //when
        Game game = new Game(carList, roundNumber);
        //then
        Assertions.assertThat(game.getcarList())
                .isEqualTo(carList);
        Assertions.assertThat(game.getRoundNumber())
                .isEqualTo(roundNumber);
    }
}
