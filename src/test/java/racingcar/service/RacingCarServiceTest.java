package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RandomNumberProvider;

class RacingCarServiceTest {
    private final int racingTime = 5;
    private final int moveForwardNumber = 5;
    private RacingCarService racingCarService = new RacingCarService(() -> moveForwardNumber);
    private final List<String> carNameList = List.of("car", "benz", "audi", "fox");

    @Test
    void prepareCars_결과_이름_동일() {
        Cars cars = racingCarService.prepareCars(carNameList);

        List<Car> carList = cars.getCars();
        List<String> prepareCarNameList = carList.stream()
            .map(Car::getName)
            .toList();

        assertThat(carNameList).isEqualTo(prepareCarNameList);
        assertThat(carNameList.size()).isEqualTo(prepareCarNameList.size());
    }

    @Test
    void startRace_전진() {

        this.racingCarService = new RacingCarService(() -> moveForwardNumber);
        Cars cars = racingCarService.prepareCars(carNameList);

        Cars startedRace = racingCarService.startRace(cars, racingTime);
        
        Assertions.assertAll(
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
        final int noMoveNumber = 2;
        final int initialProgress = 0;

        this.racingCarService = new RacingCarService(() -> noMoveNumber);
        Cars cars = racingCarService.prepareCars(carNameList);

        Cars startedRace = racingCarService.startRace(cars, racingTime);

        Assertions.assertAll(
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
    void determineRaceResult() {
    }
}