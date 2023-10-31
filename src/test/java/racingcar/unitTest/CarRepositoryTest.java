package racingcar.unitTest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.repository.CarRepository;
import racingcar.model.vo.CarName;

public class CarRepositoryTest {
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
    }

    @Test
    void should_true_when_saveSuccessful() {
        // given
        CarName carName = new CarName("park");
        Car car = new Car(carName);
        // when
        carRepository.save(carName, car);
        // then
        assertThat(carRepository.findByCarName(carName))
                .isEqualTo(car);
    }
}
