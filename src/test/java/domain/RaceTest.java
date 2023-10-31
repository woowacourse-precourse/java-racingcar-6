package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class RaceTest {

    @Test
    void runRaceTest() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        Race race = new Race(cars);
        race.runRace(5);

        assertTrue(car1.getPosition() >= 0);
        assertTrue(car2.getPosition() >= 0);
    }

    @Test
    void findWinnersTest() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        car1.moveForward(3);
        car2.moveForward(5);
        car3.moveForward(3);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        Race race = new Race(cars);
        List<Car> winners = race.findWinners();

        assertEquals(1, winners.size());
        assertTrue(winners.contains(car2));
    }
}
