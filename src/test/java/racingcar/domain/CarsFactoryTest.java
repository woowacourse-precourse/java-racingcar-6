package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsFactoryTest {

    @ParameterizedTest
    @CsvSource({"0,pobi", "1,woni", "2,jun"})
    void Factory로_Cars생성(int index, String carName) {
        //given
        List<Car> carList = Arrays.asList(
                new Car(new CarName("pobi"), new Position(0))
                , new Car(new CarName("woni"), new Position(0))
                , new Car(new CarName("jun"), new Position(0)));
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        //when
        Cars cars = CarsFactory.createCars(carNames);
        List<Car> carsFromFactory = cars.getCars();
        //then
        assertThat(carsFromFactory.get(index)).isEqualTo(new Car(new CarName(carName), new Position(0)));
    }
}
