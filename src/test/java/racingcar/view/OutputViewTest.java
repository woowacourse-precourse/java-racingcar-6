package racingcar.view;

import static org.assertj.core.api.Assertions.*;
import static racingcar.common.Config.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    OutputStream outputStream;

    @BeforeEach
    void reset() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("시작 메시지 출력")
    void testStartMessage() {
        OutputView.gameStartMessage();
        assertThat(outputStream.toString().trim()).isEqualTo(START_MESSAGE);
    }

    @Test
    @DisplayName("횟수 입력 메시지 출력")
    void testInputCountMessage() {
        OutputView.inputCountMessage();
        assertThat(outputStream.toString().trim()).isEqualTo(INPUT_COUNT_MESSAGE);
    }

    @Test
    @DisplayName("레이스 시작 메시지 출력")
    void testStartRacingMessage() {
        OutputView.startRacingMessage();
        assertThat(outputStream.toString().trim()).isEqualTo(START_RACING_MESSAGE);
    }

    @Test
    @DisplayName("각 차수별 결과 출력")
    void testEachResultMessgaee() {
        String result = "pobi : ----";

        OutputView.eachResultMessage(result);
        assertThat(outputStream.toString().trim()).isEqualTo(result);
    }

    @Test
    @DisplayName("우승자 출력")
    void testPrintWinner() {
        String stringList = "pobi, blur";

        OutputView.printWinner(stringList);
        assertThat(outputStream.toString().trim()).isEqualTo(stringList);
    }
}