package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
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

        String[] cars = {"poby", "woni", "jun"};
        int[] distance = {2, 3, 4};
        OutputView.printRoundResult(cars, distance);

        System.setOut(System.out);

        String expectedOutput = "poby : --\nwoni : ---\njun : ----\n\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void printWinner_최종우승자_출력_검증() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<String> winners = Arrays.asList("poby", "woni");
        OutputView.printWinner(winners);

        System.setOut(System.out);

        String expectedOutput = "최종 우승자 : poby, woni";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
