package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarServiceTest {

    private final CarService carService;

    CarServiceTest() {
        this.carService = new CarService();
    }

    @Test
    void 자동차_생성_테스트() {
        List<Car> cars = Arrays.asList(
                new Car("m"),
                new Car("o")
        );
        List<Car> createCars = carService.createCars("m, o");
        assertEquals(cars.get(0).getName(), createCars.get(0).getName());
        assertEquals(cars.get(1).getName(), createCars.get(1).getName());
        assertEquals(cars.get(0).getPosition(), createCars.get(0).getPosition());
        assertEquals(cars.get(1).getPosition(), createCars.get(1).getPosition());
    }
}