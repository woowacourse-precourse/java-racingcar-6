package racingcar;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

public class GameTest {

    Car car;
    Game game;
    LinkedHashMap<String, Integer> cars;


    @BeforeEach
    void setUp() {
        car = new Car();
        game = new Game(cars);
    }


    @Test
    void 자동차_이름_분리_테스트() {

        String input = "pobi,jun,king,pobi,pobi";
        String[] inputs = input.split(",");
        String[] carNames = game.splitCarName(input);

        for (int i = 0; i < carNames.length; i++) {
            Assertions.assertTrue(carNames[i].length() <= 5);
        }
        Assertions.assertTrue(carNames.length == inputs.length);

    }


    @Test
    void 자동차_맵_생성_테스트() {

        String input = "pobi,jun,king,pobi,pobi";
        String[] carNames = game.splitCarName(input);

        HashMap<String, Integer> distinctCarNames = new HashMap<>();

        for (int i = 0; i < carNames.length; i++) {
            distinctCarNames.put(carNames[i], 0);
        }
        cars = game.createCarMap(carNames);
        Assertions.assertTrue(distinctCarNames.size() == cars.size());

    }

    @Test
    void 자동차_무작위_값_생성_테스트() {
        int carNumber = game.createCarNumber();
        Assertions.assertTrue(carNumber >= 0 && carNumber <= 9);
    }


}
