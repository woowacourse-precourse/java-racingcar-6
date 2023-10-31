package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi1", "pobi2", "pobi3"})
    void 자동차_생산(String carName) {
        //given
        List<String> carNameList = List.of(carName);

        //when
        Cars cars = CarFactory.produceCars(carNameList);

        //then
        assertThat(cars.getCarList()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList())).isEqualTo(List.of(carName));
    }
}
