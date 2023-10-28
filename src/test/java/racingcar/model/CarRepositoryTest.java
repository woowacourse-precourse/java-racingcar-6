package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRepositoryTest {

    CarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
    }

    @DisplayName("Car 저장 기능 테스트")
    @Test
    void testSave() {
        int expected = 2;
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        carRepository.save(car1);
        carRepository.save(car2);

        assertEquals(expected, carRepository.getCars().size());
    }

    @DisplayName("Car 저장 중 이름 중복 검사 기능 테스트")
    @Test
    void testSaveValidateDuplicateName() {
        int expected = 2;
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("pobi");

        carRepository.save(car1);
        carRepository.save(car2);

        assertThrows(IllegalArgumentException.class, () -> carRepository.save(car3));
    }
}
