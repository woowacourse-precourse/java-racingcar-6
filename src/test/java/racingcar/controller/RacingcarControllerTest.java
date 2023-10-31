package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RacingcarControllerTest {

    Cars cars = new Cars();

    @Test
    void makeCarListTest() {
        String carNames = "pobi,woni,jun";
        Map<String, Car> carMap = cars.makeCarList(carNames);

        Car pobiCar = carMap.get("pobi");
        Car woniCar = carMap.get("woni");
        Car junCar = carMap.get("jun");

        Assertions.assertThat(carMap).contains(Map.entry("pobi",pobiCar));
        Assertions.assertThat(carMap).contains(Map.entry("woni",woniCar));
        Assertions.assertThat(carMap).contains(Map.entry("jun",junCar));
    }

}