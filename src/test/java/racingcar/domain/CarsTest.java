package racingcar.domain;

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
                Car.of(CarName.from("a")),
                Car.of(CarName.from("bb")),
                Car.of(CarName.from("ccc")),
                Car.of(CarName.from("dddd")),
                Car.of(CarName.from("eeeee")));

        // expected
        assertDoesNotThrow(() -> Cars.from(cars));
    }
}