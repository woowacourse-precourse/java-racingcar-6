package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {

    Output output = new Output();
    OutputStream outputStream;

    @BeforeEach
    void setOutput() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void printInputCarNameMessageTest() {
        //given
        output.printInputCarNameMessage();

        //when

        //then
        assertThat(outputStream.toString()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void printInputGameCountMessageTest() {
        //given
        output.printInputGameCountMessage();

        //when

        //then
        assertThat(outputStream.toString()).contains("시도할 회수는 몇회인가요?");
    }

    @Test
    void printResultMessageTest() {
        //given
        output.printResultMessage();

        //when

        //then
        assertThat(outputStream.toString()).contains("실행 결과");
    }

}