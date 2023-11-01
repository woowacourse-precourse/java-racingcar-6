package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingServiceTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    RacingService racingService = RacingService.getInstance();
    CarRepository carRepository = CarRepository.getInstance();

    List<String> carNames;

    @BeforeEach
    void beforeEach() {
        carNames = new ArrayList<>();
        carNames.add("pobi");
        carNames.add("woni");
    }

    @Test
    @DisplayName("자동차들 상태 초기화 테스트")
    void startRound() {
        racingService.startRound(carNames);

        List<Car> createdCars = carRepository.getCars();
        List<String> createdCarNames = createdCars.stream().map(Car::getName).collect(Collectors.toList());

        assertThat(carNames.equals(createdCarNames)).isTrue();
        for (Car car : createdCars) {
            assertEquals(car.getMoveCount(),0);
        }
    }

    @Test
    @DisplayName("랜덤 값에 따른 전진,멈춤 테스트")
    void processRound() {
        carRepository.createCars(carNames);

        List<Car> expectedCars = new ArrayList<>();
        expectedCars.add(new Car("pobi"));
        expectedCars.add(new Car("woni"));
        expectedCars.get(0).moveForward(MOVING_FORWARD);
        expectedCars.get(1).moveForward(STOP);

        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> processedCars = racingService.processRound();
                    for (int i=0; i<processedCars.size(); i++) {
                        assertEquals(expectedCars.get(i).getName(), processedCars.get(i).getName());
                        assertEquals(expectedCars.get(i).getMoveCount(), processedCars.get(i).getMoveCount());
                    }
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("우승자 판별 테스트")
    void decideWinner() {
        carRepository.createCars(carNames);
        assertRandomNumberInRangeTest(
                () -> {
                    racingService.processRound();
                },
                MOVING_FORWARD, STOP
        );

        List<Car> winners = racingService.decideWinner();

        assertEquals(winners.size(),1);
        assertEquals(winners.get(0).getName(),"pobi");
        assertEquals(winners.get(0).getMoveCount(),1);
    }
}