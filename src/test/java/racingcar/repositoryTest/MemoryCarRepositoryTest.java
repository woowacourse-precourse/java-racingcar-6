package racingcar.repositoryTest;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.MemoryCarRepository;

import static org.assertj.core.api.Assertions.assertThat;


public class MemoryCarRepositoryTest {
    @Test
    public void testSaveAndGetCarList() {
        CarRepository carRepository = new MemoryCarRepository();
        carRepository.save("Car1");
        carRepository.save("Car2");

        List<Car> carList = carRepository.getCarList();

        assertThat(carList).hasSize(2);
        assertThat(carList.get(0).getName()).isEqualTo("Car1");
        assertThat(carList.get(1).getName()).isEqualTo("Car2");
    }
}
