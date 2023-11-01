package racingcar.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Domain.Car;
import racingcar.Domain.RacingCars;

class CarServiceTest {
    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @Test
    void testInputCarNames() {
        String carNames = "CarA,CarB,CarC";
        RacingCars racingCars = carService.inputCarNames(carNames);

        assertThat(racingCars.getCars()).hasSize(3);
    }

    @Test
    void testRunRacing() {
        RacingCars racingCars = carService.inputCarNames("CarA,CarB,CarC");
        RaceService raceService = new RaceService();
        raceService.inputRaceCount(5);// 5번의 레이스를 시뮬레이션

        assertThat(carService.runRacing(racingCars, raceService)).hasSize(5);
    }

    @Test
    void testGetRaceResult() {
        RacingCars racingCars = carService.inputCarNames("CarA,CarB,CarC");
        racingCars.race();
        String raceResult = carService.getRaceResult(racingCars.getCars());

        assertThat(raceResult).contains("CarA").contains("CarB").contains("CarC").contains("\n");
    }

    @Test
    void testStringToList() {
        String carNames = "CarX,CarY,CarZ";
        List<Car> cars = CarService.stringToList(carNames);

        assertThat(cars).hasSize(3);
    }

    @Test
    void testCarList() {
        RacingCars racingCars = carService.inputCarNames("CarA,CarB,CarC");
        List<Car> cars = carService.carList(racingCars);

        assertThat(cars).hasSize(3);
    }
}