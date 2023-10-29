package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @DisplayName("이름 1-5자 유효성 검사 기능 테스트")
    @ParameterizedTest
    @CsvSource({"pobi ", "woni", "jun", "hi", "m"})
    void testValidateCarName(String carName) {
        assertDoesNotThrow(() -> new Car(carName));
    }

    @DisplayName("이름 1-5자 유효성 검사 기능 exception 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"hani-j", "", "exception"})
    void testValidateCarNameThrow(String carName) {
        assertThrows(IllegalArgumentException.class, () -> new Car(carName));
    }

    @DisplayName("위치 반환 기능 테스트")
    @Test
    void testGetPosition() {
        int expected = 0;

        assertEquals(expected, car.getPosition());
    }

    @DisplayName("자동차 전진 기능 테스트")
    @Test
    void testMoveForward() {
        int expected = 2;

        car.moveForward();
        car.moveForward();

        assertEquals(expected, car.getPosition());
    }
}
