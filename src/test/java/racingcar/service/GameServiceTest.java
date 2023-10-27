package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.TestNumberGenerator;

class GameServiceTest extends GameService {

    @Test
    void 최대로움직인횟수테스트() {
        //테스트 넘버로 Car 객체의 숫자 지정
        List<Car> cars = Arrays.asList(
                new Car("Car1", new TestNumberGenerator(5)), // 거리 5
                new Car("Car2", new TestNumberGenerator(3)), // 거리 3
                new Car("Car3", new TestNumberGenerator(5))  // 거리 5
        );

        // 자동차 움직이기
        cars.forEach(Car::move);
        List<String> winners = getWinnerCars(cars);

        assertEquals(2, winners.size());
        assertTrue(winners.contains("Car1"));
        assertFalse(winners.contains("Car2"));
        assertTrue(winners.contains("Car3"));
    }

    @Test
    void 아무도안움직였을때테스트() {
        //테스트 넘버로 Car 객체의 숫자 지정
        List<Car> cars = Arrays.asList(
                new Car("Car1", new TestNumberGenerator(3)),
                new Car("Car2", new TestNumberGenerator(3))
        );

        // 자동차 움직이기
        cars.forEach(Car::move);
        List<String> winners = getWinnerCars(cars);

        assertEquals(2, winners.size());
        assertTrue(winners.contains("Car1"));
        assertTrue(winners.contains("Car2"));
    }
}