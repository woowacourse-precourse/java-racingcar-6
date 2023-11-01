package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Circuit;
import racingcar.domain.MoveCondition;
import racingcar.dto.RacingResult;
import racingcar.dto.Winners;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {

    private final Car car1 = new Car("test1");
    private final Car car2 = new Car("test2");
    private final Car car3 = new Car("test3");
    private final Car car4 = new Car("test4");

    @Test
    void race() {
        RacingService racingService = RacingService.getInstance();

        Circuit circuit = Circuit.fromCarNames(List.of(car1, car2, car3, car4));

        List<RacingResult> results = racingService.race(circuit);

        assertThat(results).hasSize(4);
        assertThat(results.get(0).carName()).isEqualTo("test1");
        assertThat(results.get(1).carName()).isEqualTo("test2");
        assertThat(results.get(2).carName()).isEqualTo("test3");
        assertThat(results.get(3).carName()).isEqualTo("test4");
    }

    @Test
    void announceWinners() {
        RacingService racingService = RacingService.getInstance();

        List<Car> cars = List.of(car1, car2, car3);

        Circuit circuit = Circuit.fromCarNames(cars);

        car1.move(MoveCondition.MOVE);
        car2.move(MoveCondition.MOVE);
        car3.move(MoveCondition.STOP);

        Winners winners = racingService.findWinners(circuit);

        assertThat(winners.names().get(0)).isEqualTo("test1");
        assertThat(winners.names().get(1)).isEqualTo("test2");
    }
}