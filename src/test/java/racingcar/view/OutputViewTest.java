package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.game.RacingGame;
import racingcar.model.Car;

public class OutputViewTest {
    private RacingGame racingGame;

    @BeforeEach
    void setup() {
        String[] cars = {"poby", "woni", "jun"};
        racingGame = new RacingGame(cars);
    }

    @Test
    public void printResultCommand_실행결과_출력() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        OutputView.printResultCommand();

        System.setOut(System.out);

        assertEquals("\n실행 결과\n", outputStream.toString());
    }

    @Test
    public void printRoundResult_게임_라운드마다_출력_검증() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<Car> carList = racingGame.getCarList();
        for (Car car : carList) {
            car.move();
            car.move();
        }
        OutputView.printRoundResult(carList);

        System.setOut(System.out);

        String expectedOutput = "poby : --\nwoni : --\njun : --\n\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void printWinner_최종우승자_출력_검증() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<Car> carList = racingGame.getCarList();
        carList.get(0).move();
        carList.get(1).move();
        List<Car> winners = racingGame.getWinners();

        OutputView.printWinners(winners);
        System.setOut(System.out);

        String expectedOutput = "최종 우승자 : poby, woni";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
