package racingcar.View;


import static racingcar.Message.OutputMessage.RESULT_MESSAGE;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Message.OutputMessage;

class OutputViewTest {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); //when System.setOut(new PrintStream(outputStream));
    public OutputView outputView = new OutputView();

    @Test
    void printResult() {
    }

    @Test
    void printResultMessage() {
//        outputView.printResultMessage();
//        System.setOut(new PrintStream(outputStream));
//
//        Assertions.assertThat(OutputMessage.RESULT_MESSAGE).isEqualTo(outputStream.toString());
//        outputView.printResultMessage();
//        System.setOut(System.out);
    }

    @Test
    void printRaceResult() {
    }

    @Test
    void printWinner() {
    }

    @Test
    void printSoleWinner() {
    }

    @Test
    void printWinners() {
    }
}