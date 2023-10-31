package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.GameConstantValue;
import racingcar.entity.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.CarRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarServiceImplTest {

    CarRepository carRepository = new CarRepositoryImpl();
    Long id;

    @BeforeEach
    void before() {
        id = GameConstantValue.INIT_INDEX;
        Car car0 = new Car(id++, "test0", GameConstantValue.INIT_DISTANCE);
        Car car1 = new Car(id++, "test1", GameConstantValue.INIT_DISTANCE);
        carRepository.create(car0);
        carRepository.create(car1);
    }

    @Test
    void createCar() {
        assertThat(carRepository.findById(0L).getName()).isEqualTo("test0");
        assertThat(carRepository.findById(1L).getName()).isEqualTo("test1");
    }

    @Test
    void moveForward() {
        Car car0 = carRepository.findById(0L);

        carRepository.update(car0.getId());
        assertThat(carRepository.findById(0L).getDistance()).isEqualTo(1);

        carRepository.update(car0.getId());
        assertThat(carRepository.findById(0L).getDistance()).isEqualTo(2);
    }

    @Test
    void getListOfCarTest() {
        List<Car> cars = carRepository.findAll();

        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.get(0).getId()).isEqualTo(0L);
        assertThat(cars.get(1).getId()).isEqualTo(1L);
    }

    @Test
    void getChampionsTest() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car(5L, "pobi", 6);
        Car car2 = new Car(6L, "wonii", 5);
        Car car3 = new Car(7L, "jun", 6);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<Car> champions = new ArrayList<>();
        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
                champions.clear();
                champions.add(car);
                continue;
            }
            if (car.getDistance() == maxDistance) {
                champions.add(car);
            }
        }

        assertThat(champions.size()).isEqualTo(2);
        assertThat(champions.get(0)).isEqualTo(car1);
        assertThat(champions.get(1)).isEqualTo(car3);
    }
}