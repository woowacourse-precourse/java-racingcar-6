package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class JudgeTest {
    String name1 = "pobi";
    String name2 = "woni";
    String name3 = "jun";
    Judge judge;
    List<Car> carList;
    List<Car> winningCars;

    private void beforeEach() {
        judge = Judge.getInstance();
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);
        Car car3 = new Car(name3);

        carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        winningCars = new ArrayList<>();
    }

    @Test
    public void testGetWinningCars_multiWinners() {
        beforeEach();
        winningCars = judge.getWinningCars(carList);

        assertEquals(3, winningCars.size());
        for (int i = 0; i < 3; i++) {
            assertEquals(carList.get(i).getName(), winningCars.get(i).getName());
        }

    }

    @Test
    public void testGetWinningCars_soloWinner() {
        beforeEach();
        carList.get(0).move(1);
        carList.get(1).move(2);
        carList.get(2).move(3);

        winningCars = judge.getWinningCars(carList);

        assertEquals(1, winningCars.size());
        assertEquals(name3, winningCars.get(0).getName());
    }
}
