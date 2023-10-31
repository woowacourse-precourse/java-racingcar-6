package racingcar.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRepositoryTest {

    private CarRepository carRepository;

    @BeforeEach
    public void setup() {
        carRepository = new CarRepository();
    }

    @AfterEach
    public void clear() {
        carRepository.clear();
    }

    @Test
    public void testSave() {
        carRepository.save("Car1");
        assertThat(carRepository.size()).isEqualTo(1);
    }

    @Test
    public void testSize() {
        carRepository.save("Car1");
        carRepository.save("Car2");
        carRepository.save("Car3");
        assertThat(carRepository.size()).isEqualTo(3);
    }

    @Test
    public void testFindAll() {
        carRepository.save("Car1");
        carRepository.save("Car2");
        carRepository.save("Car3");
        assertThat(carRepository.findAll().size()).isEqualTo(3);
    }

    @Test
    public void testUpdateIncreasedCarPosition() {
        carRepository.save("Car1");
        Car car = carRepository.findAll().get(0);

        int initialPosition = car.getCarPosition();
        carRepository.updateIncreasedCarPosition(car);

        assertThat(car.getCarPosition()).isEqualTo(initialPosition + 1);
    }
}
