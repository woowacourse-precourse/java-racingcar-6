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

    @Test
    @DisplayName("차가 잘 이동하는지 확인하는 테스트코드")
    public void testMoveCar() {
        Car car = new Car("Test");
        car.move(4);
        assertEquals(1, car.getDistance());
        car.move(2);
        assertEquals(1, car.getDistance());
        car.move(5);
        assertEquals(2, car.getDistance());
    }

    @Test
    @DisplayName("예외를 잘 확인하고 처리하는지 테스트")
    public void testInvalidCarName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Car("LongName");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Car("Na me");
        });

        assertDoesNotThrow(() -> {
            new Car("A");
        });
    }

    @Test
    @DisplayName("같은 이름을 가진 객체를 하나로 만드는지 확인")
    public void testEqualsAndHashCode() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car1");

        assertEquals(car1, car3);
        assertNotEquals(car1, car2);

        assertEquals(car1.hashCode(), car3.hashCode());
        assertNotEquals(car1.hashCode(), car2.hashCode());
    }
}