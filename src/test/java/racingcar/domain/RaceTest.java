package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RaceTest {
    @DisplayName("registerCar(List<Car> carList)가 제대로 등록됨")
    @Test
    void registerCarsTest1() {
        // given
        Race race = new Race();
        List<Car> carList = Stream.of("pobi", "woni", "jun")
                .map(Car::forName)
                .toList();

        // when
        race.registerCar(carList);

        // then
        List<Car> registeredCarList = race.getCarList();
        assertArrayEquals(carList.toArray(), registeredCarList.toArray());
    }

    @DisplayName("registerCar(Car ...cars)가 제대로 등록됨")
    @Test
    void registerCarsTest2() {
        // given
        Race race = new Race();
        List<Car> carList = Stream.of("pobi", "woni", "jun")
                .map(Car::forName)
                .toList();

        // when
        race.registerCar(carList.get(0));
        race.registerCar(carList.get(1), carList.get(2));

        // then
        List<Car> registeredCarList = race.getCarList();
        assertArrayEquals(carList.toArray(), registeredCarList.toArray());
    }
}
