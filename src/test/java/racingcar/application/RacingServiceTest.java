package racingcar.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.RacingResult;
import racingcar.support.TestNumberGenerator;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.enums.RacingConfig.MOVE_CONDITION;

class RacingServiceTest {
    private final TestNumberGenerator generator = new TestNumberGenerator();
    private final RacingService racingService = new RacingService(generator);

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 전진_조건을_만족하지_않을_경우_전진하지_않는다(int wrongConditionNumber) {
        // given
        generator.setReturnNumber(wrongConditionNumber);
        Cars cars = createNewCars();

        // when
        List<RacingResult> racingResults = racingService.race(cars);

        // then
        assertThat(racingResults).extracting(RacingResult::position).containsOnly("-".repeat(0));
    }

    @Test
    void 전진_조건을_만족할_경우_한_번_전진한다() {
        // given
        generator.setReturnNumber(MOVE_CONDITION.getValue());
        Cars cars = createNewCars();

        // when
        List<RacingResult> racingResults = racingService.race(cars);

        // then
        assertThat(racingResults).extracting(RacingResult::position).containsOnly("-".repeat(1));
    }

    @Test
    void 단독_우승자를_반환한다() {
        // given
        Cars cars = createCarsWithWinner(1);

        // when
        List<String> winners = racingService.selectWinners(cars);

        // then
        assertThat(winners).hasSize(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 10})
    void 공동_우승자를_반환한다(int winnerCount) {
        // given
        Cars cars = createCarsWithWinner(winnerCount);

        // when
        List<String> winners = racingService.selectWinners(cars);

        // then
        assertThat(winners).hasSize(winnerCount);
    }

    private Cars createNewCars() {
        return createCars(5);
    }

    private Cars createCarsWithWinner(int winnerCount) {
        Cars cars = createCars(winnerCount + 10);
        IntStream.range(0, winnerCount)
                .forEach(i -> cars.findCar(i).move());
        return cars;
    }

    private Cars createCars(int createCount) {
        List<Car> cars = IntStream.range(0, createCount)
                .mapToObj(i -> new Car("car" + i))
                .toList();
        return new Cars(cars);
    }
}