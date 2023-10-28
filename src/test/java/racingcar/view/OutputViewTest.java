package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private static ByteArrayOutputStream outputMessage;
    private OutputView outputView;

    @BeforeEach
    void beforeEach() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void afterEach() {
        System.setOut(System.out);
    }

    public OutputViewTest() {
        this.outputView = OutputView.getInstance();
    }

    @Test
    public void OutputView() {
        OutputView outputView1 = OutputView.getInstance();
        OutputView outputView2 = OutputView.getInstance();

        assertEquals(outputView1, outputView2);
    }

    @Test
    public void promptCarNames() {
        outputView.promptCarNames();
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n", outputMessage.toString());
    }

    @Test
    public void promptNumberOfGameAttempts() {
        outputView.promptNumberOfGameAttempts();
        assertEquals("시도할 회수는 몇회인가요?\n", outputMessage.toString());
    }
}