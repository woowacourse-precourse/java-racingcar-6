package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    @Test
    void printTurnResult_출력_체크() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputView validTest = new OutputView();
        validTest.printTurnResult("TEST", 5);
        String printedOutput = outContent.toString().trim();

        assertThat(printedOutput).isEqualTo("TEST : -----");
    }

    @Test
    void printWinner_출력_체크() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputView validTest = new OutputView();
        List<String> nameList = Arrays.asList("TEST", "VALID", "RUN");
        validTest.printWinner(nameList);
        String printedOutput = outContent.toString().trim();

        assertThat(printedOutput).isEqualTo("최종 우승자 : TEST, VALID, RUN");
    }
}
