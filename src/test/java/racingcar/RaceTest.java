package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import racingcar.model.Car;
import racingcar.model.Race;

import java.util.ArrayList;
import java.util.List;

public class RaceTest {

    @Test
    public void testRunOneRound() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Car1"));
        cars.add(new Car("Car2"));
        Race race = new Race(cars);

        race.runOneRound();

        for (Car car : cars) {
            assertTrue(car.getDistance() >= 0 && car.getDistance() <= 1);
        }
    }

    @Test
    public void testSetWinners() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Car1"));
        cars.add(new Car("Car2"));
        cars.add(new Car("Car3"));

        // 모든 차량의 거리를 3으로 설정
        for (Car car : cars) {
            car.goForward();
            car.goForward();
            car.goForward();
        }

        Race race = new Race(cars);
        race.setWinners();

        List<Car> winners = race.getWinners();
        assertEquals(3, winners.size());
    }
}
