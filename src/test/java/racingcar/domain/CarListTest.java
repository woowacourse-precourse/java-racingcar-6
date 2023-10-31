package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarListTest {

    @Test
    public void test_addCars() {
        CarList carList = new CarList();
        String carNames = "Car1,Car2,Car3";
        String [] carNamesArray = carNames.split(",");
        carList.addCars(carNamesArray);

        List<Car> cars = carList.getCarList();
        assertEquals(3, cars.size());

        assertEquals("Car1", cars.get(0).getName());
        assertEquals("Car2", cars.get(1).getName());
        assertEquals("Car3", cars.get(2).getName());
    }

    @Test
    public void test_GetWinners() {
        CarList carList = new CarList();
        String carNames = "Car1,Car2,Car3";
        String [] carNamesArray = carNames.split(",");
        carList.addCars(carNamesArray);

        Winners winners = carList.getWinners();
        List<Car> winningCars = winners.getWinningCars();

        assertEquals(3, winningCars.size());

        for (Car car : winningCars) {
            assertTrue(carNames.contains(car.getName()));
        }
    }
}
