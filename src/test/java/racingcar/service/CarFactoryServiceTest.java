package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryServiceTest {
    @Test
    void createCarsTest() {
        // given (준비)
        List<String> carNames = Arrays.asList("car1", "car2", "car3");

        // when (실행)
        List<Car> cars = CarFactoryService.createCars(carNames);

        // then (확인)
        assertEquals(carNames.size(), cars.size(), "생성된 차의 수는 차 이름의 수와 일치해야 합니다.");

        for (int i = 0; i < cars.size(); i++) {
            assertEquals(carNames.get(i), cars.get(i).getName(), "생성된 차의 이름은 입력된 이름과 일치해야 합니다.");
        }
    }
}