package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnersTest {

    @Test
    public void test_getMaxDistance() {
        Car car1 = new Car("Car1");
        car1.move();
        Car car2 = new Car("Car2");
        car2.move();
        car2.move();
        Car car3 = new Car("Car3");
        car3.move();

        List<Car> cars = Arrays.asList(car1, car2, car3);
        Winners winners = new Winners(cars);

        int expectedMaxDistance = 2;
        int actualMaxDistance = winners.getMaxDistance();

        assertEquals(expectedMaxDistance, actualMaxDistance);
    }

    @Test
    public void test_getWinningCarNames() {
        Car car1 = new Car("Car1");
        car1.move();

        Car car2 = new Car("Car2");
        car2.move();
        car2.move();

        Car car3 = new Car("Car3");
        car3.move();
        car3.move();

        List<Car> cars = Arrays.asList(car1, car2, car3);
        Winners winners = new Winners(cars);

        List<Car> winningCars = winners.getWinningCars();

        assertTrue(winningCars.contains(car2));
        assertTrue(winningCars.contains(car3));
    }

    @Test
    public void test_EmptyCarsList() {
        List<Car> cars = Arrays.asList();

        assertThrows(IllegalArgumentException.class, () -> new Winners(cars));
    }
}
