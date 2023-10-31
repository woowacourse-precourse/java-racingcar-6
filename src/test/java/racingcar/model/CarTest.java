package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.model.Car.createCar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
    private static Car car;

    @BeforeAll
    static void setUp() {
        car = createCar("test1");
    }

    @ParameterizedTest
    @CsvSource({
            "4, 1",
            "3, 1",
            "6, 2",
            "9, 3"
    })
    void 자동차_이동_성공_테스트(int randomNumber, int expectedDistance) {
        car.move(randomNumber);
        assertEquals(expectedDistance, car.getDistance());
    }
}
