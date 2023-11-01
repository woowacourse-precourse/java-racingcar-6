package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.sevice.GameService;
import java.io.ByteArrayOutputStream;
import racingcar.view.OutputView;

public class GameServiceTest {
    private GameService gameService;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        Game game = new Game(new ArrayList<>(), 5);
        gameService = new GameService(game);
    }

    @Test
    void checkMoveTest() {
        boolean result1 = gameService.checkMove(3);
        boolean result2 = gameService.checkMove(4);
        boolean result3 = gameService.checkMove(5);

        assertEquals(false, result1);
        assertEquals(true, result2);
        assertEquals(true, result3);
    }


    @Test
    void createGameTest(){

    }


    @Test
    void getMaxPositionTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));

        for (int i = 0; i < 5; i++) {
            cars.get(0).move();
        }
        for (int i = 0; i < 3; i++) {
            cars.get(1).move();
        }
        cars.get(2).move();

        Game game = new Game(cars, 5);
        gameService = new GameService(game);

        int maxPosition = gameService.getMaxPosition();

        assertEquals(5, maxPosition);
    }

    @Test
    void printCarScoreTest() {
        System.setOut(new PrintStream(outContent));
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));

        for (int i = 0; i < 3; i++) {
            cars.get(0).move();
            cars.get(1).move();
            cars.get(2).move();
        }

        OutputView.printCarScore(cars);

        String expectedOutput = "car1 : ---\n" +
                "car2 : ---\n" +
                "car3 : ---\n" +"\n";
        assertThat(outContent.toString()).contains("car1 : ---");
        assertThat(outContent.toString()).contains("car2 : ---");
        assertThat(outContent.toString()).contains("car3 : ---");
    }

    @Test
    void printSoloWinTest() {
        System.setOut(new PrintStream(outContent));
        OutputView.printSoloWin("winner");

        String expectedOutput = "최종 우승자 : winner\n";
        assertThat(outContent.toString()).contains("최종 우승자 : winner");
    }

    @Test
    void printWinnersTest() {
        System.setOut(new PrintStream(outContent));
        List<String> winners = new ArrayList<>();
        winners.add("winner1");
        winners.add("winner2");

        OutputView.printWinners(winners);

        String expectedOutput = "최종 우승자 : winner1, winner2";

        assertThat(outContent.toString()).contains("최종 우승자 : winner1, winner2");
    }
}
