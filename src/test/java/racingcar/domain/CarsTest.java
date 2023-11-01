package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    @DisplayName("자동차들 중 최대 위치 값을 반환한다")
    void getMaxPositionTest() {
        // given
        Cars cars = Cars.from(List.of(
                Car.zeroPositionFrom("a"),
                Car.zeroPositionFrom("b"),
                Car.zeroPositionFrom("c")));

        // when
        CarPosition actual = cars.getMaxCarPosition();

        // then
        CarPosition expected = CarPosition.from(0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("이동한 자동차들 중 최대 위치 값을 반환한다")
    void getMaxPositionWithMoveTest() {
        // given
        Cars cars = Cars.from(List.of(
                Car.zeroPositionFrom("a"),
                Car.zeroPositionFrom("b"),
                Car.zeroPositionFrom("c")));
        Car firstCar = cars.getCars().get(0);
        firstCar.move(() -> true);

        // when
        CarPosition actual = cars.getMaxCarPosition();

        // then
        CarPosition expected = CarPosition.from(1);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("같은 위치에 있는 자동차들의 이름을 반환하는 테스트")
    void getSamePositionCarNamesTest() {
        // given
        Cars cars = Cars.from(List.of(
                Car.zeroPositionFrom("a"),
                Car.zeroPositionFrom("b"),
                Car.zeroPositionFrom("c")));
        CarPosition oneCarPosition = CarPosition.from(1);
        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(1).move(() -> true);

        // when
        List<String> carNames = cars.getSamePositionCarNames(oneCarPosition);

        // then
        assertAll(() -> {
            assertEquals(2, carNames.size());
            assertEquals("a", carNames.get(0));
            assertEquals("b", carNames.get(1));
        });
    }
}