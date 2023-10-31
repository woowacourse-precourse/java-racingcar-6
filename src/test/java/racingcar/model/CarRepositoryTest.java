package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRepositoryTest {

    CarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
        Car car1 = Car.from("pobi");
        Car car2 = Car.from("woni");
        Car car3 = Car.from("jun");

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
    }

    @DisplayName("Car 저장 기능 테스트")
    @Test
    void testSave() {
        int expected = 4;
        Car car4 = Car.from("hani");

        carRepository.save(car4);

        assertEquals(expected, carRepository.getCars().size());
    }

    @DisplayName("Car 저장 중 이름 중복 검사 기능 테스트")
    @Test
    void testSaveValidateDuplicateName() {
        Car car4 = Car.from("pobi");

        assertThrows(IllegalArgumentException.class, () -> carRepository.save(car4));
    }

    @DisplayName("winner 찾는 기능 테스트")
    @Test
    void testGetWinner() {
        List<String> expected = List.of("pobi", "woni", "jun");

        List<String> winner = carRepository.getWinner();

        assertEquals(expected, winner);
    }

    @DisplayName("자동차 저장 용량 검사 기능 테스트")
    @Test
    void testValidateCapacity() {
        for (int i = 0; i < 97 ; i++) {
            carRepository.save(Car.from(i + ""));
        }
        assertThrows(IllegalArgumentException.class, () -> carRepository.save(Car.from("hani")));
    }
}
