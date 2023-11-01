package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차가 하나도 존재하지 않는 경우 예외 발생")
    void emptyCarsExceptionTest() {
        // expected
        assertThrows(IllegalArgumentException.class, () -> Cars.from(List.of()));
    }

    @Test
    @DisplayName("자동차가 하나도 존재하지 않는 경우 예외 발생")
    void validCarsTest() {
        List<Car> cars = List.of(
                Car.zeroPositionFrom("a"),
                Car.zeroPositionFrom("bb"),
                Car.zeroPositionFrom("ccc"),
                Car.zeroPositionFrom("dddd"),
                Car.zeroPositionFrom("eeeee"));

        // expected
        assertDoesNotThrow(() -> Cars.from(cars));
    }

    @Test
    @DisplayName("이동 변수가 참이면 이동하는 테스트")
    void canMoveTest() {
        // given
        Cars cars = Cars.from(List.of(
                Car.zeroPositionFrom("a"),
                Car.zeroPositionFrom("bb"),
                Car.zeroPositionFrom("ccc"),
                Car.zeroPositionFrom("dddd"),
                Car.zeroPositionFrom("eeeee")));
        MovingStrategy strategy = () -> true;

        // when
        cars.moveAll(strategy);

        // then
        assertThat(cars.getCars()).allMatch(car -> car.getPosition() == 1);
    }

    @Test
    @DisplayName("이동 변수가 거짓이면 이동하지 않는 테스트")
    void canNotMoveTest() {
        // given
        Cars cars = Cars.from(List.of(
                Car.zeroPositionFrom("a"),
                Car.zeroPositionFrom("bb"),
                Car.zeroPositionFrom("ccc"),
                Car.zeroPositionFrom("dddd"),
                Car.zeroPositionFrom("eeeee")));
        MovingStrategy strategy = () -> true;

        // when
        cars.moveAll(strategy);

        // then
        assertThat(cars.getCars()).allMatch(car -> car.getPosition() == 1);
    }
}