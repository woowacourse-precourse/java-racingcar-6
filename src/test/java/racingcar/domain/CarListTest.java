package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarListTest {

    @Test
    public void testSplitName() {
        CarList carList = new CarList();
        String carNames = "Car1,Car2,Car3";
        String[] expectedNames = {"Car1", "Car2", "Car3"};
        assertArrayEquals(expectedNames, carList.splitName(carNames));
    }

    @Test
    public void testAddCars() {
        CarList carList = new CarList();
        String[] carNames = {"Car1", "Car2", "Car3"};
        carList.addCars(carNames);

        List<Car> cars = carList.getCarList();
        assertEquals(carNames.length, cars.size());

        for (int i = 0; i < carNames.length; i++) {
            assertEquals(carNames[i], cars.get(i).getName());
        }
    }

    @Test
    public void testSplitCarNames(){
        CarList carList = new CarList();
        String carNames = "Car1,Car2,Car3";
        carList.splitCarNames(carNames);

        List<Car> cars = carList.getCarList();
        assertEquals(3, cars.size());

        assertEquals("Car1", cars.get(0).getName());
        assertEquals("Car2", cars.get(1).getName());
        assertEquals("Car3", cars.get(2).getName());
    }

    @Test
    public void testGetWinners() {
        CarList carList = new CarList();
        String carNames = "Car1,Car2,Car3";
        carList.splitCarNames(carNames);

        Winners winners = carList.getWinners();
        List<Car> winningCars = winners.getWinningsCars();
        assertEquals(3, winningCars.size());

        for (Car car : winningCars) {
            assertTrue(carNames.contains(car.getName()));
        }
    }

}
