package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MyCarTest {

    @Test
    public void testGetCarName() {
        MyCar car = new MyCar(1, "Finn");

        assertEquals("Finn", car.getCarName());
    }

    @Test
    public void testToString() {
        MyCar car = new MyCar(1, "Car3");

        car.setForward("--");

        assertEquals("Car3 : --", car.toString());
    }
}
