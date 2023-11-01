package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    public void testRace() {
        Cars cars = new Cars(new String[]{"Car1", "Car2", "Car3"});
        cars.race();
        List<Car> carList = cars.cars;
        for (Car car : carList) {
            assertTrue(car.getPosition() >= 0);
        }
    }

    @Test
    public void testGetWinners() {
        Cars cars = new Cars(new String[]{"Car1", "Car2", "Car3"});
        List<Car> winners = cars.getWinners();
        assertEquals(3, winners.size());
    }

}