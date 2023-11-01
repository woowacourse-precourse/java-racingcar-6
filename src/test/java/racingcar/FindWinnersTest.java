package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindWinnersTest {
    private FindWinners findWinners;

    @BeforeEach
    public void setUp() {
        findWinners = new FindWinners();
    }

    @Test
    public void testGetWinners() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        car1.forward();
        car1.forward();
        car2.forward();
        car3.forward();
        car3.forward();

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<Car> winners = findWinners.getWinners(cars);

        assertEquals(2, winners.size());
        assertEquals("Car1", winners.get(0).getName());
        assertEquals("Car3", winners.get(1).getName());
    }

    @Test
    public void testGetWinnersWithEqualPositions() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        car1.forward();
        car2.forward();
        car3.forward();

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<Car> winners = findWinners.getWinners(cars);

        assertEquals(3, winners.size());
        assertEquals("Car1", winners.get(0).getName());
        assertEquals("Car2", winners.get(1).getName());
        assertEquals("Car3", winners.get(2).getName());
    }
}
