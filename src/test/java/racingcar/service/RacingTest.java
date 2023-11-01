package racingcar.service;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class RacingTest {

    Racing racing;
    List<Car> carList;
    private void preset(){
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        carList = new ArrayList<>();

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        racing = new Racing();
    }
    @Test
    public void testPlayARound() {
        preset();
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
        Racing racing = new Racing();

        // Test that the generated random number is within the specified range
        Integer randomNumber = racing.generateRandomNumber();
        assertTrue(randomNumber >= 0);
        assertTrue(randomNumber <= 9);
    }
}
