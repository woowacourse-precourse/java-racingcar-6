package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("TestCar");
    }

    @Test
    @DisplayName("유효하지 않은 이름을 가진 차 생성")
    void invalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Car(""));
        assertThrows(IllegalArgumentException.class, () -> new Car("VeryLongName"));
    }
    @Test
    @DisplayName("차의 이름 가져오기")
    void getName() {
        assertEquals("TestCar", car.getName());
    }
}
