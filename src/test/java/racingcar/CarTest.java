package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.LinkedHashMap;

import java.util.List;
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
//        car = new Car(cars);
        game = new Game();

    }

//    @Test
//    void 자동차_전진_테스트() {
//        int carNumber = game.createCarNumber();
//        System.out.println(carNumber);
//        int location = car.moveForward(,carNumber);
//        System.out.println(location);
//        Assertions.assertTrue(location >= 1);
//
//    }


    @Test
    void 자동차_무작위_값_생성_테스트() {
        int carNumber = car.createRandomNumber();
        Assertions.assertTrue(carNumber >= 0 && carNumber <= 9);
    }

    @Test
    void 자동차_맵_생성_테스트() {

        String input = "pobi,jun,king,pobi,pobi";
        List<String> carNameList = game.splitCarName(input);

        HashMap<String, Integer> distinctCarNames = new HashMap<>();

        for (int i = 0; i < carNameList.size(); i++) {
            distinctCarNames.put(carNameList.get(i), 0);
        }
//        cars = car.createLocationMap(carNameList);
        Assertions.assertTrue(distinctCarNames.size() == cars.size());

    }


}
