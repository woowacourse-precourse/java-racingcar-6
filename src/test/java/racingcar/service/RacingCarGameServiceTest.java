package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.race.RaceChecker;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameServiceTest {
    RacingCarGameService gameService = new RacingCarGameService(new RaceChecker());

    @Test
    @DisplayName("play는 자동차 리스트를 받아 각 자동차를 이동시킨다.")
    void play() {
        List<Car> cars = List.of(
                new Car("pobi", () -> true),
                new Car("crong", () -> true),
                new Car("honux", () -> true)
        );

        gameService.play(cars);

        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }
}