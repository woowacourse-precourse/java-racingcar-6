package racingcar;

import racingcar.model.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CarTest {

    @Test
    public void testCarInitialization() {
        String carName = "absy";
        Car car = new Car(carName);

        assertEquals(carName, car.getName());
        assertEquals(0, car.getMoveCount());
    }

    @Test
    public void testCarComparison() {
        Car car1 = new Car("absy");
        Car car2 = new Car("pobi");

        while (car1.getMoveCount() == 0) {
            car1.attemptMove();
        }

        assertTrue(car1.compareTo(car2) < 0);
    }

    @Test
    public void testCarToString() {
        String carName = "absy";
        Car car = new Car(carName);
        while (car.getMoveCount() == 0) {
            car.attemptMove();
        }

        String expectedString = carName + " : -";
        assertEquals(expectedString, car.toString());
    }
}
