package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.configuration.AppConfig;
import racingcar.configuration.Config;
import racingcar.domain.racing.car.Car;

public class MemoryCarRepositoryTest {

    Config config = AppConfig.getInstance();
    private CarRepository memoryCarRepository = config.carRepository();

    @BeforeEach
    public void setUp() {
        memoryCarRepository.deleteAll();
    }

    @Test
    public void 새로운_Car저장() {
        // given
        String name = "car1";
        final Car car = Car.create(name);

        // when
        final Car result = (Car) memoryCarRepository.save(car);

        // then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getName()).isEqualTo("car1");
    }

    @Test
    public void Car_Id값이_1부터1씩커지는지() {
        // given
        final Car car1 = Car.create("car1");
        final Car car2 = Car.create("car2");

        // when
        final Car result1 = (Car) memoryCarRepository.save(car1);
        final Car result2 = (Car) memoryCarRepository.save(car2);

        // then
        assertThat(result1.getId()).isEqualTo(1L);
        assertThat(result2.getId()).isEqualTo(2L);
    }

    @Test
    public void Car_Id로_객체찾기() {
        // given
        final Car car1 = Car.create("car1");

        // when
        memoryCarRepository.save(car1);
        final Optional<Car> findResult = memoryCarRepository.findById(1L);

        // then
        assertThat(findResult.isPresent()).isTrue(); // Optional이 존재해야 함
        assertThat(findResult.get()).isEqualTo(car1);
    }

    @Test
    public void 모든Car객체반환() {
        // given
        final Car car1 = Car.create("car1");
        final Car car2 = Car.create("car2");

        // when
        memoryCarRepository.save(car1);
        memoryCarRepository.save(car2);
        List<Car> carList = memoryCarRepository.findAll();

        // then
        assertThat(carList.size()).isEqualTo(2);
    }

}
