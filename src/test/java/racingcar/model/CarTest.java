package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @ParameterizedTest
    @CsvSource({
            "dddddd",
            "ddd ddd"
    })
    void 자동차_이름_길이_실패_테스트(String name) {
        assertThrows(IllegalArgumentException.class,
                () -> createCar(name));
    }

    @ParameterizedTest
    @CsvSource({
            "pobi",
            "javaj",
            "ooooo ",
            "oo oo"
    })
    void 자동차_이름_길이_성공_테스트(String name) {
        assertDoesNotThrow(
                () -> createCar(name));
    }
}
