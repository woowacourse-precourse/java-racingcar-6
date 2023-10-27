package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

public class CarTest {

    Car car;
    Game game;

    LinkedHashMap<String, Integer> cars;

    @BeforeEach
    void setUp() {
        car = new Car(cars);
        game = new Game();

    }

    @Test
    void 자동차_전진_테스트() {
        int carNumber = game.createCarNumber();
        System.out.println(carNumber);
        int location = car.moveForward(carNumber);
        System.out.println(location);
        Assertions.assertTrue(location >= 1);

    }

    @Test
    void 자동차_맵_생성_테스트() {

        String input = "pobi,jun,king,pobi,pobi";
        String[] carNames = game.splitCarName(input);

        HashMap<String, Integer> distinctCarNames = new HashMap<>();

        for (int i = 0; i < carNames.length; i++) {
            distinctCarNames.put(carNames[i], 0);
        }
        cars = car.createLocationMap(carNames);
        Assertions.assertTrue(distinctCarNames.size() == cars.size());

    }


}
