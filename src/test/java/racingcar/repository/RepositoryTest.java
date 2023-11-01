package racingcar.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

public class RepositoryTest {

    CarRepository carRepository =new CarRepository();

    @AfterEach
    public void afterEach(){
        carRepository.clearStore();
    }

    @Test
    public void car_save(){
        Car car = new Car("super");

        carRepository.save(car);

        Car result=carRepository.findById(car.getId());
        Assertions.assertThat(car).isEqualTo(result);
    }

    @Test
    public void findAll(){
        Car car1 = new Car("super");
        carRepository.save(car1);

        Car car2 = new Car("duper");
        carRepository.save(car2);

        List<Car> result=carRepository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(carRepository.getId());
    }
}
