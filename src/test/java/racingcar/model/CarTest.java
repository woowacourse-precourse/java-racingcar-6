package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("Car 객체 잘 만들어지는지 테스트")
    public void testCarCreation() {
        Car car = new Car("Test");
        assertEquals("Test", car.getName());
        assertEquals(0, car.getDistance());
    }
}