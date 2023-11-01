package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    private Car car;
    @Test
    public void testCarCreation() {
        Car car = new Car("Test");
        assertEquals("Test", car.getCarName());
        assertEquals(0, car.getDistance());
    }

    @Test
    public void testCarDrive() {
        Car car = new Car("Test");
        car.drive();
        assertEquals(0, car.getDistance());

        car.getEngine().setEngine(5);
        car.drive();
        assertEquals(1, car.getDistance());
    }

    @Test
    public void testCarTrace() {
        Car car = new Car("Test");
        assertEquals("Test : ", car.getTrace());

        car.getEngine().setEngine(5);
        car.drive();
        assertEquals("Test : -", car.getTrace());
    }

    @Test
    public void testEngine() {
        Engine engine = new Engine();
        int power = engine.getPower();
        assertTrue(power >= 0 && power <= 9);
    }
    @Test
    void testInvalidCarName() {
        assertThatThrownBy(() -> new Car("TestCar"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("5자리 이하의 이름을 입력해야 합니다.");
    }

}
