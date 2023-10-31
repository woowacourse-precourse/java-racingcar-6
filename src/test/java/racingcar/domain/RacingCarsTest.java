package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    RacingCars racingCars;

    int movingCount = 5;

    @BeforeEach
    void setUp() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("toby"));
        cars.add(new Car("ben"));
        cars.add(new Car("lee"));

        racingCars = new RacingCars(cars);

        for (int i = 0; i < movingCount; i++) {
            racingCars.MovingCars();
            racingCars.racingCarResultPrint();
        }
    }

    @Test
    void movingCarsTest() {
        String[] winners = racingCars.getRacingWinners();

        assertThat(winners.length).isGreaterThan(0);
        assertThat(winners).containsAnyOf("ben", "toby", "lee");
    }

}