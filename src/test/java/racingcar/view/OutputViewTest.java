package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private PrintStream standardOut;
    private OutputStream captor;
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        this.standardOut = System.out;
        this.captor = new ByteArrayOutputStream();
        this.outputView = new OutputView();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void cleanUp() {
        System.setOut(standardOut);
    }


    @Test
    @DisplayName("실행 결과 메세지 출력")
    void printGameResultMessage() throws Exception {
        //given

        //when
        outputView.printGameResultMessage();
        String output = captor.toString();
        //then
        assertThat(output).contains("실행 결과");
    }

    @Test
    @DisplayName("자동차 및 로그 출력")
    void printCarAndLog() throws Exception {
        //given
        String car = "A";
        String log = "--";
        //when
        outputView.printCarAndLog(car, log);
        String output = captor.toString();
        //then
        assertThat(output).contains("A", "--");
    }

    @Test
    @DisplayName("우승자 출력")
    void printWinner() throws Exception {
        //given
        String winner = "A";
        //when
        outputView.printWinner(winner);
        String output = captor.toString();
        //then
        assertThat(output).contains("A");
    }
}