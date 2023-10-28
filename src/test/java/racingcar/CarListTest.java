package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarListTest {
    @Test
    void CarList_테스트() {
        List<String> inputList = Arrays.asList("red", "green", "blue");
        List<Car> carList = RacingUtil.createCarsFromNames(inputList);

        CarList resultList = new CarList(carList);

        assertEquals(resultList.size(), inputList.size());
        assertTrue(resultList.contains(carList.get(0)));
        assertTrue(resultList.contains(carList.get(1)));
        assertTrue(resultList.contains(carList.get(2)));
    }

    @Test
    void findMaxPosition_테스트() {
        List<String> inputList = Arrays.asList("red", "green", "blue");
        List<Car> carList = RacingUtil.createCarsFromNames(inputList);
        carList.get(1).move();
        carList.get(1).move();

        CarList resultList = new CarList(carList);

        assertEquals(2, resultList.findMaxPosition());
    }

    @Test
    void findWinners_테스트() {
        List<String> inputList = Arrays.asList("red", "green", "blue");
        List<Car> carList = RacingUtil.createCarsFromNames(inputList);
        carList.get(1).move();
        carList.get(2).move();

        CarList resultList = new CarList(carList);
        List<Car> winners = resultList.findWinners();

        assertEquals(2, winners.size());
        assertTrue(winners.contains(carList.get(1)));
        assertTrue(winners.contains(carList.get(2)));
    }
}
