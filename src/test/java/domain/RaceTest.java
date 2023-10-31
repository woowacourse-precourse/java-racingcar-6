package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
