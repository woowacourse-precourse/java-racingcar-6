package racingcar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.stubbing.OngoingStubbing;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class RacingGameTest {

    final int ENOUGH_BIG_NUMBER = 10000;
    RandomNumberMaker randomNumberMaker = new RandomNumberMaker();
    String lineSeparator = System.lineSeparator();
    @Test
    void canCreateCars() throws NoSuchFieldException, IllegalAccessException {
        RacingGame racingGame = new RacingGame();
        String[] answer = {"car1", "car2", "car3"};
        String[] result = new String[3];
        racingGame.createCars(answer);
        Field cars = racingGame.getClass().getDeclaredField("cars");
        cars.setAccessible(true);
        ArrayList<Car> carNames= (ArrayList<Car>) cars.get(racingGame);
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
    void canMoveCars() {
        RacingGameUtils racingGameUtils = new RacingGameUtils();
        Car car = new Car("car1");
        racingGameUtils.moveCar(car, 8);
        racingGameUtils.moveCar(car, 2);
        racingGameUtils.moveCar(car, 7);
        assertEquals(2,car.getLocation());
    }

    @Test
    void canGetCurrentStatus() throws NoSuchFieldException, IllegalAccessException {
        RacingGame racingGame = new RacingGame();
        RacingGameUtils racingGameUtils = new RacingGameUtils();
        LinkedHashMap<String, Integer> answer = new LinkedHashMap<>();
        String[] carNames = {"car1", "car2", "car3"};
        racingGame.createCars(carNames);
        Field cars = racingGame.getClass().getDeclaredField("cars");
        cars.setAccessible(true);
        answer.put("car1", 3);
        answer.put("car2", 5);
        answer.put("car3", 2);
        ArrayList<Car> carSet = (ArrayList<Car>) cars.get(racingGame);
        for(int moveTimes = 0; moveTimes < 3; moveTimes++) {
            racingGameUtils.moveCar(carSet.get(0), 9);
        }
        for(int moveTimes = 0; moveTimes < 5; moveTimes++) {
            racingGameUtils.moveCar(carSet.get(1), 9);
        }
        for(int moveTimes = 0; moveTimes < 2; moveTimes++) {
            racingGameUtils.moveCar(carSet.get(2), 9);
        }
        assertEquals(answer, racingGame.getCurrentStatus());
    }

    @Test
    void canGetWinners() throws NoSuchFieldException, IllegalAccessException {
        RacingGame racingGame = new RacingGame();
        RacingGameUtils racingGameUtils = new RacingGameUtils();
        ArrayList<String> answer = new ArrayList<>(List.of("car2"));
        String[] carNames = {"car1", "car2", "car3"};
        racingGame.createCars(carNames);
        Field cars = racingGame.getClass().getDeclaredField("cars");
        cars.setAccessible(true);
        ArrayList<Car> carSet = (ArrayList<Car>) cars.get(racingGame);
        for(int moveTimes = 0; moveTimes < 3; moveTimes++) {
            racingGameUtils.moveCar(carSet.get(0), 9);
        }
        for(int moveTimes = 0; moveTimes < 5; moveTimes++) {
            racingGameUtils.moveCar(carSet.get(1), 9);
        }
        for(int moveTimes = 0; moveTimes < 2; moveTimes++) {
            racingGameUtils.moveCar(carSet.get(2), 9);
        }
        assertEquals(answer,racingGame.getWinner());
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2\n3"})
    void canPlayRacingGame(String userInput) {

        int[] randomContents = {8, 7, 9, 0, 3, 1};
        GameMachine gameMachine = new GameMachine();
        final MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        OngoingStubbing<Integer> stubbing = mock.when(() -> Randoms.pickNumberInRange(0, 9));
        for (int randomContent : randomContents) {
           stubbing = stubbing.thenReturn(randomContent);
        }
        InputStream userInputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(userInputStream);
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        gameMachine.playRacingGame();
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + lineSeparator
                + "시도할 회수는 몇회인가요?" + lineSeparator +  lineSeparator
                + "실행 결과" + lineSeparator
                + "car1 : -" + lineSeparator + "car2 : -" + lineSeparator + lineSeparator
                + "car1 : --" + lineSeparator + "car2 : -" + lineSeparator + lineSeparator
                + "car1 : --" + lineSeparator + "car2 : -" + lineSeparator + lineSeparator
                + "최종 우승자 : car1" + lineSeparator, output.toString());
    }
}