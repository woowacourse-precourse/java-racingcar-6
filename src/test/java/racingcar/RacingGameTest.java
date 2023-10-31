package racingcar;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {

    final int ENOUGH_BIG_NUMBER = 10000;
    RandomNumberMaker randomNumberMaker = new RandomNumberMaker();
    @Test
    void canCreateCars() throws NoSuchFieldException, IllegalAccessException {
        RacingGame racingGame = new RacingGame();
        String[] answer = {"car1", "car2", "car3"};
        String[] result = new String[3];
        racingGame.createCars(answer);
        Field cars = racingGame.getClass().getDeclaredField("cars");
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
        RacingGame racingGame = new RacingGame();
        Car car = new Car("car1");
        racingGame.moveCar(car, 8);
        racingGame.moveCar(car, 2);
        racingGame.moveCar(car, 7);
        assertEquals(2,car.getLocation());
    }

    @Test
    void canGetCurrentStatus() throws NoSuchFieldException, IllegalAccessException {
        RacingGame racingGame = new RacingGame();
        LinkedHashMap<String, Integer> answer = new LinkedHashMap<String, Integer>();
        String[] carNames = {"car1", "car2", "car3"};
        racingGame.createCars(carNames);
        Field cars = racingGame.getClass().getDeclaredField("cars");
        cars.setAccessible(true);
        answer.put("car1", 3);
        answer.put("car2", 5);
        answer.put("car3", 2);
        ArrayList<Car> carSet = (ArrayList<Car>) cars.get(racingGame);
        for(int moveTimes = 0; moveTimes < 3; moveTimes++) {
            racingGame.moveCar(carSet.get(0), 9);
        }
        for(int moveTimes = 0; moveTimes < 5; moveTimes++) {
            racingGame.moveCar((Car) carSet.get(1), 9);
        }
        for(int moveTimes = 0; moveTimes < 2; moveTimes++) {
            racingGame.moveCar((Car) carSet.get(2), 9);
        }
        assertEquals(answer, racingGame.getCurrentStatus());
    }

    @Test
    void canGetWinners() throws NoSuchFieldException, IllegalAccessException {
        RacingGame racingGame = new RacingGame();
        ArrayList<String> answer = new ArrayList<>(List.of("car2"));
        String[] carNames = {"car1", "car2", "car3"};
        racingGame.createCars(carNames);
        Field cars = racingGame.getClass().getDeclaredField("cars");
        cars.setAccessible(true);
        ArrayList<Car> carSet = (ArrayList<Car>) cars.get(racingGame);
        for(int moveTimes = 0; moveTimes < 3; moveTimes++) {
            racingGame.moveCar(carSet.get(0), 9);
        }
        for(int moveTimes = 0; moveTimes < 5; moveTimes++) {
            racingGame.moveCar((Car) carSet.get(1), 9);
        }
        for(int moveTimes = 0; moveTimes < 2; moveTimes++) {
            racingGame.moveCar((Car) carSet.get(2), 9);
        }
        assertEquals(answer,racingGame.getWinner());
    }
}
