package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarGameController;
import racingcar.model.Car;
import racingcar.model.Game;

public class GameTest {

    private Game game;


    @BeforeEach
    void setUp() {
        game = new Game();
    }


    @Test
    void 자동차_이름_분리_테스트() {

        String input = "pobi,jun,king,pom";
        String[] inputs = input.split(",");
        List<String> carNameList = game.splitCarName(input);

        assertThat(carNameList).contains("pobi", "pom", "jun", "pobi", "king");
        assertThat(carNameList).containsExactly("pobi", "jun", "king", "pom");

        for (int i = 0; i < carNameList.size(); i++) {
            Assertions.assertTrue(carNameList.get(i).length() <= 5);
        }
        Assertions.assertTrue(carNameList.size() == inputs.length);

    }

    @Test
    void 게임_결과_판단_테스트() {
        CarGameController carGameController = new CarGameController();
        List<String> carNameList = List.of("pobi", "jun", "king", "mimi");
        List<Car> cars = carGameController.createCars(carNameList);
        List<String> winners = game.judgeWinner(cars);

        assertThat(winners).hasSize(4);
    }


}
