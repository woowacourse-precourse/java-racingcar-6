package racingcar.repository;

import org.junit.jupiter.api.Test;
import racingcar.entity.Car;
import racingcar.entity.Game;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    @Test
    void saveTest() {
        CarRepository carRepository = new CarRepository();
        Car car = new Car("car");

        Car result = carRepository.save(car);

        assertEquals(result, car);
    }



    @Test
    void findByNameTest() {
        CarRepository carRepository = new CarRepository();
        Car car = new Car("car");
        carRepository.save(car);


        Car result =carRepository.findByName("car");

        assertEquals(result, car);
    }

}