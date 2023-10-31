package racingcar.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarsTest {

    @Test
    void createCars() {
        List<String> carNames = List.of("CAR1", "CAR2", "CAR3");
        List<Car> cars = Cars.createCars(carNames);
        assertThat(cars).hasSize(3);
    }

    @Test
    void selectionWinners() {
        List<Car> carList = List.of(new Car("Car1"), new Car("Car2"), new Car("Car3"));
        Cars cars = new Cars();

        String winners = cars.selectionWinners(carList);
        assertThat(winners).isEqualTo("Car1, Car2, Car3");
    }
}