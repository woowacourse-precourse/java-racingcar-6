package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void Cars_race(int index) {
        List<Car> carList = Arrays.asList(
                new Car(new CarName("pobi"), new Position(0))
                , new Car(new CarName("woni"), new Position(0))
                , new Car(new CarName("jun"), new Position(0)));
        Cars cars = new Cars(carList);
        cars.race(() -> true);
        assertThat(cars.getCars().get(index).getPosition()).isEqualTo(new Position(1));
    }
}
