package racingcar.domain;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RaceTest {
    @DisplayName("registerCar(List<Car> carList)가 제대로 등록됨")
    @Test
    void registerCarsTest1() {
        // given
        Race race = new Race();
        List<Car> carList = Stream.of("pobi", "woni", "jun")
                .map(Car::from)
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
                .map(Car::from)
                .toList();

        // when
        race.registerCar(carList.get(0));
        race.registerCar(carList.get(1), carList.get(2));

        // then
        List<Car> registeredCarList = race.getCarList();
        assertArrayEquals(carList.toArray(), registeredCarList.toArray());
    }

    @DisplayName("proceedCars()가 모든자동차들의 proceed를 시도")
    @Test
    void proceedCars() {
        // given
        Race race = new Race();
        List<Car> carList = Stream.of("pobi", "woni", "jun")
                .map(Car::from)
                .map(Mockito::spy)
                .toList();

        race.registerCar(carList);

        // when
        for (int i = 0; i < 3; i++) {
            race.proceedCars();
        }

        // then
        assertThat(carList).allSatisfy(car ->
                verify(car, times(3)).isProceedNext());
    }
}
