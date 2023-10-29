package racingcar.application;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Car;
import racingcar.dto.RacingResult;
import racingcar.enums.RacingConfig;
import racingcar.support.TestNumberGenerator;

class RacingServiceTest {
    private final TestNumberGenerator generator = new TestNumberGenerator();
    private final RacingService racingService = new RacingService(generator);

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 전진_조건을_만족하지_않을_경우_전진하지_않는다(int wrongConditionNumber) {
        // given
        generator.setReturnNumber(wrongConditionNumber);
        int createCount = 3;
        List<Car> cars = createCars(createCount);

        // when
        List<RacingResult> racingResults = racingService.race(cars);

        // then
        assertThat(racingResults).extracting(RacingResult::position).containsOnly("-".repeat(0));
    }

    @Test
    void 전진_조건을_만족할_경우_한_번_전진한다() {
        // given
        generator.setReturnNumber(RacingConfig.MOVE_CONDITION.getValue());
        int createCount = 5;
        List<Car> cars = createCars(createCount);

        // when
        List<RacingResult> racingResults = racingService.race(cars);

        // then
        assertThat(racingResults).extracting(RacingResult::position).containsOnly("-".repeat(1));
    }

    @Test
    void 단독_우승자를_반환한다() {
        // given
        List<Car> cars = createCarsWithWinner(1);

        // when
        List<String> winners = racingService.selectWinners(cars);

        // then
        assertThat(winners).hasSize(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 10})
    void 공동_우승자를_반환한다(int winnerCount) {
        // given
        List<Car> cars = createCarsWithWinner(winnerCount);

        // when
        List<String> winners = racingService.selectWinners(cars);

        // then
        assertThat(winners).hasSize(winnerCount);
    }

    private List<Car> createCars(int createCount) {
        return IntStream.range(0, createCount)
                .mapToObj(i -> new Car("test"))
                .toList();
    }

    private List<Car> createCarsWithWinner(int winnerCount) {
        List<Car> cars = createCars(winnerCount + 10);
        cars.stream()
                .limit(winnerCount)
                .forEach(Car::move);
        return cars;
    }
}