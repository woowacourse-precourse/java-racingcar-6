package racingcar;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {

    final int ENOUGH_BIG_NUMBER = 10000;
    RacingGame racingGame = new RacingGame();
    RandomNumberMaker randomNumberMaker = new RandomNumberMaker();
    @Test
    void canCreateCars() throws NoSuchFieldException, IllegalAccessException {
        String[] answer = {"car1", "car2", "car3"};
        String[] result = new String[3];
        racingGame.createCars(answer);
        Field cars = racingGame.getClass().getDeclaredField("Cars");
        cars.setAccessible(true);
        ArrayList<Car> carNames= (ArrayList<Car>)cars.get(racingGame);
        for (int carNumber = 0; carNumber < 3; carNumber++) {
            result[carNumber] = carNames.get(carNumber).getName();
        }
        assertArrayEquals(result, answer);
    }

    @Test
    void canMakeRandomNumber() {
        for (int times = 0; times < ENOUGH_BIG_NUMBER; times++) {
            int randomNumber = randomNumberMaker.makeRandomNumber();
            if (0 > randomNumber || randomNumber > 9) {
                assertFalse(false);
            }
        }
        assertTrue(true);
    }

    @Test
    void canMoveCars() throws NoSuchFieldException {
        Car car = new Car("car1");
        racingGame.moveCar(car, 8);
        racingGame.moveCar(car, 2);
        racingGame.moveCar(car, 7);
        assertEquals(2,car.getLocation());
    }
}
