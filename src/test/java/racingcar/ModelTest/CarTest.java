package racingcar.ModelTest;

import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testGetName() {
        Car car = new Car("Car1");

        assertEquals("Car1", car.getName());
    }

    @Test
    public void testGetMoveCount() {
        Car car = new Car("Car1");

        assertEquals(0, car.getMoveCount());
    }

    @Test
    public void testAccel() {
        Car car = new Car("Car1");

        car.accel();

        assertEquals(1, car.getMoveCount());
        assertEquals("Car1 : -", car.getCurrentState());
    }

    @Test
    public void testGetCurrentState() {
        Car car = new Car("Car1");

        String currentState = car.getCurrentState();

        assertEquals("Car1 : ", currentState);
    }
}

