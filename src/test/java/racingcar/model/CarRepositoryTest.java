package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRepositoryTest {

    @Test
    void getCars() {
        //when
        CarRepository carRepository = new CarRepository(List.of("test1", "test2"));
        List<Car> cars = carRepository.getCars();

        //then
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.get(0).getName()).isEqualTo("test1");
        assertThat(cars.get(1).getName()).isEqualTo("test2");
    }

    @Test
    void getMaxCars() {
        CarRepository carRepository = new CarRepository(List.of("test1", "test2", "test3"));
        List<Car> cars = carRepository.getCars();

        cars.get(0).moveForward();
        cars.get(2).moveForward();

        List<String> maxCars = carRepository.getMaxCars();
        assertThat(maxCars.size()).isEqualTo(2);
        assertThat(maxCars).contains("test1", "test3");

    }
}