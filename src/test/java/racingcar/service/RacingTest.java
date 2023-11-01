package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.configurations.GameConfigurations.CONTROL_VALUE;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;

public class RacingTest {
    Racing racing;
    List<Car> carList;

    private void beforeEach() {
        racing = Racing.getInstance();

        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        carList = new ArrayList<>();

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
    }

    @Test
    public void testPlayARound() {
        beforeEach();
        racing.playARound(carList);

        boolean anyCarMoved = false;
        for (Car car : carList) {
            if (car.getLocation() > 0) {
                anyCarMoved = true;
                break;
            }
        }
        assertTrue(anyCarMoved);
    }

    @Test
    public void testGenerateRandomNumber() {
        beforeEach();
        Integer randomNumber = racing.generateRandomNumber();
        assertTrue(randomNumber >= 0);
        assertTrue(randomNumber <= 9);
    }

    @Test
    public void testIsMove() {
        beforeEach();

        assertTrue(racing.isMove(CONTROL_VALUE.get()));
        assertFalse(racing.isMove(CONTROL_VALUE.get() - 1));
    }
}
