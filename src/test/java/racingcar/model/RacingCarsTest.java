package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars();
        racingCars.addCar(new Car("pobi"));
        racingCars.addCar(new Car("woni"));
        racingCars.addCar(new Car("jun"));
    }

    @Test
    void addCarTest() {
        racingCars.addCar(new Car("han"));
        assertThat(racingCars.getRacingCars()).hasSize(4);
    }

    @Test
    void getRacingCarsTest() {
        List<Car> cars = racingCars.getRacingCars();
        assertThat(cars).extracting("name").containsExactly("pobi", "woni", "jun");
    }

    @Test
    void findWinnersTest() {
        racingCars.getRacingCars().get(0).moveForward();
        racingCars.getRacingCars().get(0).moveForward();
        racingCars.getRacingCars().get(1).moveForward();

        List<Car> winners = racingCars.findWinners();
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }

    @Test
    void getCarNamesTest() {
        List<String> carNames = racingCars.getCarNames();
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }
}
