package racingcar;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

public class GameTest {

    Car car;
    Game game;

    @BeforeEach
    void setUp() {
        car = new Car();
        game = new Game();
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
        String[] inputs = input.split(",");
        String[] carNames = game.splitCarName(input);
        LinkedHashMap<String, Integer> cars = game.createCarMap(carNames);

        for (int i = 0; i < inputs.length; i++) {
            cars.putIfAbsent(inputs[i], 0);
            cars.put(inputs[i], cars.get(inputs[i]) + 1);
        }

        Assertions.assertTrue(carNames.length == cars.size());

    }


}
