package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.CarList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomGameRuleTest {

    private RandomGameRuleImpl gameRule;
    private CarList carList;

    @BeforeEach
    public void setUp() {
        carList = new CarList();

        carList.addCar(new Car("Car1"));
        carList.addCar(new Car("Car2"));
        carList.addCar(new Car("Car3"));

        gameRule = new RandomGameRuleImpl(carList);
    }

    @Test
    public void testProgressCar() {
        gameRule.progressCar(carList.get(0), 0);
        gameRule.progressCar(carList.get(1), 1);
        gameRule.progressCar(carList.get(2), 9);

        assertEquals(0, carList.get(0).getDistance());
        assertEquals(0, carList.get(1).getDistance());
        assertEquals(1, carList.get(2).getDistance());
    }

    @Test
    public void testCalculateWinner() {
        gameRule.progressCar(carList.get(0), 9);
        gameRule.progressCar(carList.get(1), 9);
        gameRule.progressCar(carList.get(2), 9);

        String winner1 = gameRule.calculateWinner();

        assertEquals("Car1, Car2, Car3", winner1);

        gameRule.progressCar(carList.get(0), 9);
        gameRule.progressCar(carList.get(1), 0);
        gameRule.progressCar(carList.get(2), 0);

        String winner2 = gameRule.calculateWinner();

        assertEquals("Car1", winner2);
    }
}
