package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class JudgeTest {
    Judge judge;
    List<Car> carList;

    private void preset() {
        judge = Judge.getInstance();

        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
    }

    @Test
    public void testGetWinningCars() {
        preset();
        List<Car> winningCars = judge.getWinningCars(carList);

        assertEquals(3, winningCars.size());
        for (int i = 0; i < 3; i++) {
            assertEquals(carList.get(i).getName(), winningCars.get(i).getName());
        }

        for (Car car : carList) {
            car.setWinner(false);
        }

        carList.get(0).move(1);
        carList.get(1).move(2);
        carList.get(2).move(3);

        winningCars = judge.getWinningCars(carList);
        assertEquals(1, winningCars.size());
        assertEquals("jun", winningCars.get(0).getName());
    }
}
