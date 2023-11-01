package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceControllerTest {
    @Test
    void 자동차_경주_컨트롤러_실행() {
        List<Car> cars = Arrays.asList(new Car("pobi"), new Car("woni"), new Car("jun"));
        RaceController raceController = new RaceController(cars);

        int numOfMoves = 5;
        raceController.run(numOfMoves);

        for (Car car : cars) {
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    void 자동차_경주_컨트롤러_우승자_확인() {
        List<Car> cars = Arrays.asList(new Car("pobi"), new Car("woni"), new Car("jun"));
        RaceController raceController = new RaceController(cars);

        cars.get(0).move();
        cars.get(0).move();
        cars.get(1).move();
        cars.get(2).move();

        List<Car> winners = raceController.getWinners();

        int maxPosition = winners.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(0);

        List<Car> expectedWinners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());

        assertThat(winners).containsExactlyElementsOf(expectedWinners);
    }

    @Test
    void 유효한_시도_횟수_테스트() {
        int validAttempts = 5;
        List<Car> cars = new ArrayList<>();
        RaceController raceController = new RaceController(cars);

        boolean isValid = raceController.validateNumberOfAttempts(validAttempts);

        assertThat(isValid).isTrue();
    }

    @Test
    void 유효하지_않은_시도_횟수_테스트() {
        int invalidAttempts = -1;
        List<Car> cars = new ArrayList<>();
        RaceController raceController = new RaceController(cars);

        boolean isValid = raceController.validateNumberOfAttempts(invalidAttempts);

        assertThat(isValid).isFalse();
    }
}
