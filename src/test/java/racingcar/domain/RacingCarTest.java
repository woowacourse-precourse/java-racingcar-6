package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.exception.NonNullCarNameException;

class RacingCarTest {
    @Test
    public void testConstructorWithValidName() {
        RacingCar car = new RacingCar("car1");
        assertEquals("car1", car.getName());
        assertEquals(0, car.getLocation());
    }

    @Test
    public void testConstructorWithEmptyName() {
        assertThrows(NonNullCarNameException.class, () -> new RacingCar(""));
    }

    @Test
    public void testConstructorWithNullName() {
        assertThrows(NonNullCarNameException.class, () -> new RacingCar(null));
    }

    @Test
    public void testGoForwardOrStop_Move() {
        RacingCar car = new RacingCar("car1");
        car.goForwardOrStop(4);
        assertEquals(1, car.getLocation());
    }

    @Test
    public void testGoForwardOrStop_NoMove() {
        RacingCar car = new RacingCar("car1");
        car.goForwardOrStop(3);
        assertEquals(0, car.getLocation());
    }

}