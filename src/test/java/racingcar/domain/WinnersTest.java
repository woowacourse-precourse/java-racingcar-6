package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnersTest {

    @Test
    public void 자동차가_없는_경우_최대이동거리() {
        Winners winners = new Winners(Arrays.asList());

        assertEquals(0, winners.getMaxDistance());
    }

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
        assertEquals(2, winners.getMaxDistance());
    }

    @Test
    public void test_WinningCars() {
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
        List<Car> winningCars = winners.getWinningsCars();

        assertTrue(winningCars.contains(car2));
        assertTrue(winningCars.contains(car3));
    }
}
