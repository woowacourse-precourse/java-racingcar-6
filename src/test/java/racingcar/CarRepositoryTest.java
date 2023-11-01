package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarRepositoryImpl;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRepositoryTest {
    CarRepositoryImpl carRepository = new CarRepositoryImpl();

    @Test
    void inputCarTest() {
        String[] testNames = {"a","b","c"};
        List<Car> cars = carRepository.save(testNames);
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getName()).isEqualTo(testNames[i]);
            assertThat(cars.get(i).getCount()).isEqualTo(0);
        }
    }

    @Test
    void notMoveTest() {
        Car car = new Car("A");
        carRepository.moveForward(car, 1);
        assertThat(car.getCount()).isEqualTo(0);
    }

    @Test
    void MoveTest() {
        Car car = new Car("A");
        carRepository.moveForward(car, 5);
        assertThat(car.getCount()).isEqualTo(1);
    }

    @Test
    void MoveAndNotTest() {
        Car car = new Car("A");
        carRepository.moveForward(car, 5);
        assertThat(car.getCount()).isEqualTo(1);
        carRepository.moveForward(car, 0);
        assertThat(car.getCount()).isEqualTo(1);
    }
}
