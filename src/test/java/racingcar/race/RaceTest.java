package racingcar.race;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;

public class RaceTest {
    @Test
    public void 레이스_생성_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Car1"));
        cars.add(new Car("Car2"));
        Race race = new Race(cars);
        assertNotNull(race);
    }

    @Test
    public void 레이스_getCars_테스트() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        cars.add(car1);
        cars.add(car2);
        Race race = new Race(cars);
        assertEquals(cars, race.getCars());
    }
}
