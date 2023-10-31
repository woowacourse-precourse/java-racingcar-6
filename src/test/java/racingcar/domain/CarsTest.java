package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.dto.CarDto;

class CarsTest {
    @Test
    void 주어진_자동차_이름_목록을_통해_객체를_생성한다() {
        List<String> carNames = List.of("apple", "melon", "lime");
        Cars cars = Cars.from(carNames);

        assertThat(cars.dtos())
                .extracting(CarDto::name)
                .containsExactlyInAnyOrderElementsOf(carNames);
    }

    @ParameterizedTest
    @MethodSource("moveArgumentsProvider")
    void 주어진_MovingStrategy에_따라_모든_Car를_이동시킨다(MovingStrategy movingStrategy, int expectedPosition) {
        Cars cars = Cars.from(List.of("apple", "melon", "lime"));
        cars.move(movingStrategy);

        assertThat(cars.dtos())
                .extracting(CarDto::position)
                .containsOnly(expectedPosition);
    }

    static Stream<Arguments> moveArgumentsProvider() {
        return Stream.of(
                Arguments.of((MovingStrategy) () -> true, 1),
                Arguments.of((MovingStrategy) () -> false, 0)
        );
    }
}

