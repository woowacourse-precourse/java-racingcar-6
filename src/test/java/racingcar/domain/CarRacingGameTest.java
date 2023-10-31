package racingcar.domain;

import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.repository.CarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingGameTest {

    @Test
    public void testSaveCars() {
        CarRepository carRepository = new CarRepository();
        CarRacingGame carRacingGame = new CarRacingGame();

        String[] carNames = {"Car1", "Car2", "Car3"};
        carRacingGame.saveCars(carNames);

        List<Car> cars = carRepository.findAll();
        assertThat(cars.size()).isEqualTo(carNames.length);
    }

    @Test
    public void testGetWinningCarNames() {
        CarRacingGame carRacingGame = new CarRacingGame();
        CarRepository carRepository = new CarRepository();

        String[] carNames = {"Car1", "Car2", "Car3"};
        carRacingGame.saveCars(carNames);

        carRepository.updateIncreasedCarPosition(carRepository.findAll().get(1));

        List<String> winningCarNames = carRacingGame.getWinningCarNames();
        assertThat(carRepository.findAll().get(1).getCarName()).isEqualTo(winningCarNames.get(0));
    }
}
