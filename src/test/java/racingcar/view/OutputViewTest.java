package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("'실행 결과'문구 출력에 성공한다.")
    public void printResultCommandTest() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        OutputView.printResultCommand();

        System.setOut(System.out);

        assertEquals("\n실행 결과\n", outputStream.toString());
    }

    @Test
    @DisplayName("게임 라운드마다 출력 검증에 성공한다.")
    public void printRoundResultTest() {
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
    @DisplayName("최종 우승자 출력에 성공한다.")
    public void printWinnerTest() {
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
