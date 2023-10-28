package racingcar.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.dto.CarProgressResponse;
import racingcar.model.Cars;
import racingcar.model.GameResult;

class RacingCarServiceTest {
    private final int racingTime = 5;
    private RacingCarService racingCarService;
    private final List<String> carNameList = List.of("car", "benz", "audi", "fox");

    @Test
    void prepareCars_결과_이름_동일() {
        initMoveService();
        Cars cars = racingCarService.prepareCars(carNameList);

        List<Car> carList = cars.getCars();
        List<String> prepareCarNameList = carList.stream()
            .map(Car::getName)
            .toList();

        assertAll(
            () -> assertThat(carNameList).isEqualTo(prepareCarNameList),
            () -> assertThat(carNameList.size()).isEqualTo(prepareCarNameList.size())
        );
    }

    @Test
    void startRace_전진() {
        initMoveService();
        Cars cars = racingCarService.prepareCars(carNameList);

        Cars startedRace = racingCarService.startRace(cars, racingTime);
        
        assertAll(
            () -> assertThat(startedRace.getWinner()).isEqualTo(carNameList),
            () -> assertThat(startedRace.getWinner().size()).isEqualTo(carNameList.size()),
            () -> {
                for (Car car : startedRace.getCars()) {
                    assertThat(car.getProgress()).isEqualTo(racingTime);
                }
            }
        );
    }


    @Test
    void startRace_전진_못함() {
        initNotMoveService();
        Cars cars = racingCarService.prepareCars(carNameList);
        final int initialProgress = 0;

        Cars startedRace = racingCarService.startRace(cars, racingTime);

        assertAll(
            () -> assertThat(startedRace.getWinner()).isEqualTo(carNameList),
            () -> assertThat(startedRace.getWinner().size()).isEqualTo(carNameList.size()),
            () -> {
                for (Car car : startedRace.getCars()) {
                    assertThat(car.getProgress()).isEqualTo(initialProgress);
                }
            }
        );
    }

    @Test
    void determineRaceResult_전진() {
        initMoveService();
        List<Car> carList = carNameList.stream()
            .map(Car::from)
            .toList();

        Cars cars = racingCarService.startRace(Cars.from(carList), racingTime);

        GameResult gameResult = racingCarService.determineRaceResult(cars);

        assertAll(
            () -> assertThat(gameResult.winners()).isEqualTo(carNameList),
            () -> assertThat(gameResult.progressResponses().size()).isEqualTo(carList.size()),
            () -> {
                for (CarProgressResponse progressRespons : gameResult.progressResponses()) {
                    assertThat(progressRespons.result()).isEqualTo(racingTime);
                }
            }
        );
    }

    private void initNotMoveService() {
        final int noMoveNumber = 2;
        this.racingCarService = new RacingCarService(() -> noMoveNumber);
    }

    private void initMoveService() {
        final int moveForwardNumber = 5;
        this.racingCarService = new RacingCarService(() -> moveForwardNumber);
    }

    @Test
    void race_성공() {
        initMoveService();
        GameResult gameResult = racingCarService.race(carNameList, racingTime);

        assertAll(
            () -> assertThat(gameResult.winners()).isEqualTo(carNameList),
            () -> assertThat(gameResult.progressResponses().size()).isEqualTo(carNameList.size()),
            () -> {
                for (CarProgressResponse progressRespons : gameResult.progressResponses()) {
                    assertThat(progressRespons.result()).isEqualTo(racingTime);
                }
            }
        );
    }
}