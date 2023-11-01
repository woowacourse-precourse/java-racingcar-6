package racingcar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {
    @Test
    void createRacingCarWithName() {
        String name = "test";
        RacingCar car = new RacingCar(name);
        assertEquals(name, car.getName());
    }


}
