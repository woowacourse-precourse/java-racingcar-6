package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RaceResult;
import racingcar.model.Car;
import racingcar.repository.CarRepository;
import racingcar.util.ProductionRandomNumberUtil;
import racingcar.util.RandomNumberUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameServiceTest {

    @DisplayName("자동차 경주를 진행할 횟수를 받으면, 받은 횟수만큼 경기를 진행하고 그 결과를 반환한다.")
    @Test
    void Given_raceCount_When_Racing_Then_ReturnRaceResults() throws Exception {
        // Given
        CarRepository carRepository = setTestCarRepository();
        GameService gameService = new GameService(carRepository);
        int raceCount = 5;

        // When
        List<RaceResult> raceResults = gameService.race(raceCount);

        // Then
        assertThat(raceResults).hasSize(raceCount);
    }

    private CarRepository setTestCarRepository() {
        RandomNumberUtil randomNumberUtil = new ProductionRandomNumberUtil();
        List<Car> cars = List.of(
                new Car(randomNumberUtil, "a", 0),
                new Car(randomNumberUtil, "b", 0),
                new Car(randomNumberUtil, "c", 0)
        );
        CarRepository carRepository = new CarRepository();
        carRepository.saveAll(cars);

        return carRepository;
    }

    @DisplayName("자동차 경주 우승자 목록을 반환한다.")
    @Test
    void Given_GameService_When_GetWinners_Then_Winners() throws Exception {
        // Given
        String winnerName = "edgar";
        int maximumDistance = 3;
        CarRepository carRepository = setTestCarRepository(winnerName, maximumDistance);
        GameService gameService = new GameService(carRepository);

        // When
        List<String> winners = gameService.getWinners();

        // Then
        assertThat(winners).contains(winnerName);
    }

    private CarRepository setTestCarRepository(String name, int distance) {
        RandomNumberUtil randomNumberUtil = new ProductionRandomNumberUtil();
        List<Car> cars = List.of(
                new Car(randomNumberUtil, name, distance),
                new Car(randomNumberUtil, "b", 0),
                new Car(randomNumberUtil, "c", 0)
        );
        CarRepository carRepository = new CarRepository();
        carRepository.saveAll(cars);

        return carRepository;
    }
}
