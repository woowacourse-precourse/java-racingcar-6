package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class RacingCarServiceTest {

    @DisplayName("문자열 리스트 타입 변환 테스트")
    @Test
    void testFormatCarNames() {
        List<String> carNames = List.of("car A", "car B", "car C");

        List<Car> cars = RacingCarService.convertCarNames(carNames);

        assertEquals(3, cars.size());
        assertEquals("car A", cars.get(0).getName());
        assertEquals("car B", cars.get(1).getName());
        assertEquals("car C", cars.get(2).getName());
    }

    @DisplayName("우승 후보 계산 테스트")
    @Test
    void testCalculatWinner() {
        Car car1 = new Car("car A",5);
        Car car2 = new Car("car B", 2);
        Car car3 = new Car("car C", 5);
        List<Car> cars = List.of(car1,car2,car3);


        List<Car> winners = RacingCarService.calculatWinner(cars);

        assertEquals(List.of(car1,car3),winners);
    }
}