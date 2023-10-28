package racingcar;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarGameController;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Game;

public class GameTest {

    Game game;


    @BeforeEach
    void setUp() {
        game = new Game();
    }


    @Test
    void 자동차_이름_분리_테스트() {

        String input = "pobi,jun,king,pobi,pobi";
        String[] inputs = input.split(",");
        List<String> carNameList = game.splitCarName(input);

        for (int i = 0; i < carNameList.size(); i++) {
            Assertions.assertTrue(carNameList.get(i).length() <= 5);
        }
        Assertions.assertTrue(carNameList.size() == inputs.length);

    }

    @Test
    void 게임_결과_판단_테스트() {
        CarGameController carGameController = new CarGameController();
        List<String> carNameList = new ArrayList<>();
        carNameList.add("pobi");
        carNameList.add("jun");
        carNameList.add("king");
        carNameList.add("mimi");
        List<Car> cars = carGameController.createCars(carNameList);
        List<String> winners;
        winners = game.judgeWinner(cars);

        Assertions.assertEquals(4, winners.size());

    }


}
