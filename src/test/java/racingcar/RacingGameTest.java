package racingcar;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class RacingGameTest {

    RacingGame racingGame = new RacingGame();
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

    void canMoveCars() {

    }
}
