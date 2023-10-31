package racingcar.domain;

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
    @DisplayName("registerCars(List<Car> carList)가 제대로 등록됨")
    @Test
    void registerCarsTest1() {
        // given
        Race race = new Race();
        List<Car> carList = Stream.of("pobi", "woni", "jun")
                .map(Car::from)
                .toList();

        // when
        race.registerCars(carList);

        // then
        List<Car> registeredCarList = race.getCarList();
        assertArrayEquals(carList.toArray(), registeredCarList.toArray());
    }

    @DisplayName("registerCars(Car ...cars)가 제대로 등록됨")
    @Test
    void registerCarsTest2() {
        // given
        Race race = new Race();
        List<Car> carList = Stream.of("pobi", "woni", "jun")
                .map(Car::from)
                .toList();

        // when
        race.registerCars(carList.get(0));
        race.registerCars(carList.get(1), carList.get(2));

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

        race.registerCars(carList);

        // when
        for (int i = 0; i < 3; i++) {
            race.proceedCars();
        }

        // then
        assertThat(carList).allSatisfy(car ->
                verify(car, times(3)).isProceedNext());
    }

    @DisplayName("toString()이 올바른 포멧으로 반환한다.")
    @Test
    void toStringTest() {
        // given
        Race race = new Race();
        List<Car> carList = List.of(
                Car.from("pobi", 3),
                Car.from("woni", 2),
                Car.from("jun", 3)
        );

        // when
        race.registerCars(carList);

        // then
        assertThat(race.toString()).isEqualTo("""
                pobi : ---
                woni : --
                jun : ---
                """);
    }

    @DisplayName("제일 빠른 자동차들을 반환")
    @Test
    void getHeadCarsTest() {
        // given
        Race race = new Race();
        List<Car> carList = List.of(
                Car.from("pobi", 3),
                Car.from("woni", 2),
                Car.from("jun", 3)
        );
        race.registerCars(carList);

        // when
        List<Car> headCars = race.getHeadCars();

        // then
        assertThat(headCars)
                .map(Car::getName)
                .containsExactly("pobi", "jun");
    }
}
