package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarFactoryTest {

    @Test
    void Factory로_Cars생성() {
        //given
        List<Car> carList = Arrays.asList(
                new Car(new CarName("pobi"), new Position(0))
                , new Car(new CarName("woni"), new Position(0))
                , new Car(new CarName("jun"), new Position(0)));
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        //when
        Cars cars = CarFactory.createCars(carNames);
        List<Car> carsFromFactory = cars.getCars();
        //then
        assertThat(carsFromFactory.get(0)).isEqualTo(new Car(new CarName("pobi"), new Position(0)));
    }
}
