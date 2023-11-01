package racingcar.domain.console.output;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleWriterTest {
    private static final String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String FINAL_WINNERS_PREFIX = "최종 우승자 : ";

    private final ConsoleWriter consoleWriter = ConsoleWriter.newInstance();

    @Test
    void 입력_메시지_출력_테스트() {
        // given
        // when
        String printedMessage = captureConsoleOutput(consoleWriter::inputNamesMessagePrint);

        // then
        assertThat(printedMessage)
                .isEqualTo(INPUT_NAMES_MESSAGE);
    }

    @Test
    void 횟수_입력_메시지_출력_테스트() {
        // given
        // when
        String printedMessage = captureConsoleOutput(consoleWriter::inputCountMessagePrint);

        // then
        assertThat(printedMessage)
                .isEqualTo(INPUT_ATTEMPT_COUNT_MESSAGE);
    }

    @Test
    void 최종_우승자_출력_테스트() {
        // given
        String finalWinningCarNames = "pobi, woni, jun";

        // when
        String printedMessage = captureConsoleOutput(() -> consoleWriter.finalWinnersPrint(finalWinningCarNames));

        // then
        assertThat(printedMessage)
                .isEqualTo(FINAL_WINNERS_PREFIX + finalWinningCarNames);
    }

    private String captureConsoleOutput(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        runnable.run();

        System.setOut(originalOut);
        return outputStream.toString().trim();
    }
    
}