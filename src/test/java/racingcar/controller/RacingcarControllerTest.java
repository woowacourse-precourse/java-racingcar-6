package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.RacingcarView;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class RacingcarControllerTest {

    Cars cars = new Cars();

    @Test
    void makeCarListTest() {
        String carNames = "pobi,woni,jun";
        Map<String, Car> carMap = cars.makeCarList(carNames);

        Car pobiCar = carMap.get("pobi");
        Car woniCar = carMap.get("woni");
        Car junCar = carMap.get("jun");

        assertThat(carMap).contains(Map.entry("pobi",pobiCar));
        assertThat(carMap).contains(Map.entry("woni",woniCar));
        assertThat(carMap).contains(Map.entry("jun",junCar));
    }

    @Test
    void moveForwardTest() {
        Car car1 = new Car("pobi", 0);
        Car car2 = new Car("woni", 0);

        for (int i = 0; i < 10; i++) {
            car1.moveForward();
        }

        assertThat(car1.getDistance()).isNotEqualTo(car2.getDistance());
    }
}