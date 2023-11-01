package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingServiceTest {

    RacingService racingService = RacingService.getInstance();
    CarRepository carRepository = CarRepository.getInstance();

    @Test
    @DisplayName("자동차들 상태 초기화 테스트")
    void startRound() {
        List<String> carNames = new ArrayList<>();
        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("jun");

        racingService.startRound(carNames);

        List<Car> createdCars = carRepository.getCars();
        List<String> createdCarNames = createdCars.stream().map(Car::getName).collect(Collectors.toList());

        assertThat(carNames.equals(createdCarNames)).isTrue();
        for (Car car : createdCars) {
            assertEquals(car.getMoveCount(),0);
        }
    }

    @Test
    @DisplayName("주어진 횟수 동안 전진,멈춤 테스트")
    void processRound() {
        // TODO: 테스트코드 작성
    }

    @Test
    @DisplayName("우승자 판별 테스트")
    void decideWinner() {
        // TODO: 테스트코드 작성
    }
}