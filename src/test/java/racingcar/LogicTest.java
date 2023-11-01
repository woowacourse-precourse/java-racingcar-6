package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.Domain.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {

    @Test //7번 기능 테스트
    void findMaxPosition() {
        List<Car> cars = List.of(new Car("pobi"), new Car("crong"), new Car("honux"));
        cars.get(0).setPosition(1L);
        cars.get(1).setPosition(2L);
        cars.get(2).setPosition(3L);

        List<Car> winnerCars = Logic.findMaxPosition(cars);
        List<Car> expectedWinnerCars = List.of(new Car("honux"));
        expectedWinnerCars.get(0).setPosition(3L);
        assertEquals(expectedWinnerCars, winnerCars);
    }
}