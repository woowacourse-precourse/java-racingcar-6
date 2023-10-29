package racingcar.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.entity.Car;
import racingcar.exception.CarRepositoryException;

class CarRepositoryTest {
    CarRepository carRepository = new CarRepository();

    @BeforeEach
    void setUp() {
        carRepository.clearAll();
    }

    @AfterEach
    void tearDown() {
        carRepository.clearAll();
    }

    @Test
    @DisplayName("자동차를 생성한다.")
    void save() {
        // given
        String carName = "pobi";
        Car car = Car.create(carName);

        // when
        Car save = carRepository.save(car).get();

        // then
        assertAll(
                () -> assertThat(save).isNotNull(),
                () -> assertThat(save.getCarName()).isEqualTo(carName),
                () -> assertThat(save.getDistance()).isEqualTo(0)
        );
    }

    @Disabled
    @Test
    @DisplayName("같은 이름으로 자동차를 저장하려고 하면 예외가 발생한다.")
    void saveDuplicatedException() {
        // given
        String carName = "pobi";
        Car car = Car.create(carName);

        // when
        carRepository.save(car);

        // then
        assertThatThrownBy(() -> carRepository.save(car))
                .isInstanceOf(CarRepositoryException.class)
                .hasMessage(CarRepositoryException.DUPLICATE);

    }

    @Test
    @DisplayName("자동차 이름으로 자동차를 조회힌다.")
    void findByCarName() {
        // given
        String carName = "pobi";
        Car car = Car.create(carName);

        carRepository.save(car);

        // when
        Car findCar = carRepository.findByCarName(carName).get();

        // then
        assertAll(
                () -> assertThat(findCar).isNotNull(),
                () -> assertThat(findCar.getCarName()).isEqualTo(car.getCarName()),
                () -> assertThat(findCar.getDistance()).isEqualTo(car.getDistance())
        );
    }

    @Test
    @DisplayName("저장된 모든 자동차를 조회한다.")
    void findAll() {
        // given
        String carName1 = "pobi1";
        String carName2 = "pobi2";

        Car car1 = Car.create(carName1);
        Car car2 = Car.create(carName2);

        carRepository.save(car1);
        carRepository.save(car2);

        // when
        List<Car> cars = carRepository.findAll();

        // then
        assertThat(cars).hasSize(2)
                .extracting("carName", "distance")
                .contains(
                        Tuple.tuple("pobi1", 0),
                        Tuple.tuple("pobi2", 0)
                );
    }
}