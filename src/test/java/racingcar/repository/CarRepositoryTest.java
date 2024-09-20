package racingcar.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.util.RandomNumberUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRepositoryTest {

    @DisplayName("자동차 객체 리스트를 받으면, 저장한다.")
    @Test
    void Given_Cars_When_Then_SaveAllCars() throws Exception {
        // Given
        Car car1 = new Car(createBoundedRandomNumberGenerator(), "edgar", 0);
        Car car2 = new Car(createBoundedRandomNumberGenerator(), "elmo", 0);
        Car car3 = new Car(createBoundedRandomNumberGenerator(), "kue", 0);
        List<Car> cars = List.of(car1, car2, car3);
        CarRepository carRepository = new CarRepository();

        // When
        carRepository.saveAll(cars);

        // Then
        List<Car> savedCars = carRepository.getAll();
        assertThat(cars).hasSize(3);
    }

    private RandomNumberUtil createBoundedRandomNumberGenerator() {
        return new RandomNumberUtil() {
            @Override
            public int generateNumberInRange(int startNumber, int endNumber) {
                return 5;
            }
        };
    }

    @DisplayName("저장된 모든 자동차 객체를 반환한다.")
    @Test
    void Given_CarRepository_When_GetAll_Then_ReturnCars() throws Exception {
        // Given
        Car car1 = new Car(createBoundedRandomNumberGenerator(), "edgar", 0);
        Car car2 = new Car(createBoundedRandomNumberGenerator(), "elmo", 0);
        List<Car> cars = List.of(car1, car2);
        CarRepository carRepository = new CarRepository();
        carRepository.saveAll(cars);

        // When
        List<Car> savedCars = carRepository.getAll();

        // Then
        assertThat(savedCars.get(0)).isEqualTo(car1);
        assertThat(savedCars.get(1)).isEqualTo(car2);
    }
}
