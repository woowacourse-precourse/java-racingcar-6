package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.Config;

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
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(Config.START_MESSAGE);
    }

    @Test
    @DisplayName("횟수 입력 메시지 출력")
    void testInputCountMessage() {
        OutputView.inputCountMessage();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(Config.INPUT_COUNT_MESSAGE);
    }

    @Test
    @DisplayName("레이스 시작 메시지 출력")
    void testStartRacingMessage() {
        OutputView.startRacingMessage();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(Config.START_RACING_MESSAGE);
    }

    @Test
    @DisplayName("각 차수별 결과 출력")
    private void testEachResultMessgaee() {
        String result = "pobi : ----";

        OutputView.eachResultMessgae(result);
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(result);
    }

    @Test
    @DisplayName("우승자 출력")
    void testPrintWinner() {
        String stringList = "pobi, blur";

        OutputView.printWinner(stringList);
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(Config.WINNER_MESSAGE + stringList);
    }
}