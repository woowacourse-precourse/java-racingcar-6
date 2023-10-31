package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputManager;

class OutputManagerTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 경주할_자동차_입력요청_메시지_출력() {
        // given
        OutputManager outputManager = new OutputManager();

        // when
        outputManager.printRequestCarNameInputMessage();

        // then
        assertThat(outputStreamCaptor.toString().trim()).contains(OutputManager.REQUEST_CAR_NAME_INPUT);
    }

    @Test
    void 게임_진행_회수_입력요청_메시지_출력() {
        // given
        OutputManager outputManager = new OutputManager();

        // when
        outputManager.printRequestGameCountInputMessage();

        // then
        assertThat(outputStreamCaptor.toString().trim()).contains(OutputManager.REQUEST_GAME_COUNT_INPUT);
    }
}
