package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RoundTest {

    @Test
    void moveAllCarsOneRound_shouldMoveAllCars() {

        List<Car> cars = new ArrayList<>();
        cars.add(Car.nameOf("car1"));
        cars.add(Car.nameOf("car2"));
        Round round = Round.carsOf(cars);

        round.moveAllCarsOneRound();

        for (Car car : cars) {
            assertThat(car.getPosition()).isIn(0, 1);
        }
    }
}
