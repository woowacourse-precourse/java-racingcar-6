package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Game;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    @Test
    void forwardOrStop_메소드_인자_배열_변화_테스트() {
        List<Car> cars = new ArrayList<>();

        for (Integer number = 1; number <= 3; number++) {
            cars.add(new Car("car" + number));
        }
        Game.forwardOrStop(cars);

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getScore());
        }
    }
}
