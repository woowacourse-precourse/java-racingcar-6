package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private Game game;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        game = new Game();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testWhoIsWinner() {
        List<Integer> cars = Arrays.asList(3, 5, 2, 5);
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3", "Car4");
        game.whoIsWinner(cars, carNames);
        String expectedOutput = "최종 우승자 : Car2, Car4";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    public void testCompareMax() {
        List<Integer> cars = Arrays.asList(3, 5, 2, 5);
        List<Integer> expectedWinners = Arrays.asList(1, 3);
        List<Integer> winners = game.compareMax(cars);
        assertEquals(expectedWinners, winners);
    }

    @Test
    public void testMax() {
        List<Integer> numbers = Arrays.asList(3, 5, 2, 5);
        Integer expectedMax = 5;
        Integer max = game.max(numbers);
        assertEquals(expectedMax, max);
    }

    @Test
    public void testInputPlayTimes() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Integer playTimes = game.inputPlayTimes();
        assertEquals(Integer.valueOf(5), playTimes);
    }

    @Test
    public void testCheckPlayTimesInput() {
        String input = "abc";
        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.checkPlayTimesInput(input);
        });
        assertEquals("시도할 횟수 입력이 잘못되었습니다.", exception.getMessage());
    }


    @Test
    public void testCheckPlayersName() {
        List<String> inputs = Arrays.asList("Car1", "Car2", "Car3");
        game.checkPlayersName(inputs);
    }

    @Test
    public void testCheckNameLength() {
        String name = "Car123";
        IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.checkNameLength(name);
        });
        assertEquals("입력 값이 5자를 초과합니다.", exception.getMessage());
    }

    @Test
    public void testGoForwardOrNot() {
        boolean result1 = game.goForwardOrNot(3);
        boolean result2 = game.goForwardOrNot(5);
        assertEquals(false, result1);
        assertEquals(true, result2);
    }

    @Test
    public void testCreateRandomNum() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomNumbers.add(game.creatRandomNum());
        }
        assertEquals(10, randomNumbers.size());
    }

    @Test
    public void testRaceEachTimes() {
        List<Integer> cars = new ArrayList<>(Arrays.asList(0, 0, 0));
        game.raceEachTimes(cars);
    }
}