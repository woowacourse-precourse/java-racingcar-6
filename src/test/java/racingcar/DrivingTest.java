package racingcar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//GPT CODE
public class DrivingTest {

    @Test
    public void testRace() {
        MyCar[] cars = new MyCar[2];
        cars[0] = new MyCar(1, "Car4");
        cars[1] = new MyCar(2, "Car5");

        MyCar[] result = Driving.race(3, cars);

        assertEquals(cars, result);
    }

    @Test
    public void testRaceWinner() {
        MyCar[] cars = new MyCar[3];
        cars[0] = new MyCar(1, "Car6");
        cars[1] = new MyCar(2, "Car7");
        cars[2] = new MyCar(3, "Car8");

        Driving.raceWinner(5, cars);
    }
}
