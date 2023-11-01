package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 생성_시_자동차_이름이_중복되면_예외가_발생한다() {
        List<String> carNames = List.of("apple", "melon", "melon");
        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("moveArgumentsProvider")
    void 자동차_이동_시_주어진_MovingStrategy에_따라_모든_Car를_이동시킨다(MovingStrategy movingStrategy, int expectedPosition) {
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

    @Test
    void 위치가_최대인_자동차들의_DTO_리스트를_반환한다() {
        List<Car> givenCars = List.of(
                new Car(CarName.from("apple"), CarPosition.from(2)),
                new Car(CarName.from("melon"), CarPosition.from(3)),
                new Car(CarName.from("lime"), CarPosition.from(3))
        );
        Cars cars = new Cars(givenCars);

        assertThat(cars.maxPositionCarDtos())
                .extracting(CarDto::name)
                .containsExactlyInAnyOrder("melon", "lime");
    }
}

