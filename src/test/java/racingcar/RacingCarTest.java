package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;
import racingcar.Controller.RacingCar;

public class RacingCarTest {
    @Test
    public void testInitializeCars() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        List<Car> cars = RacingCar.initializeCars(carNames);

        assertEquals(carNames.size(), cars.size());
        for (int i = 0; i < carNames.size(); i++) {
            assertEquals(carNames.get(i), cars.get(i).carName);
            assertEquals(0, cars.get(i).carPosition);
        }
    }
}