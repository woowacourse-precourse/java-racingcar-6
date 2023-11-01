package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

public class OutputViewTest {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @DisplayName("실행 결과 메세지 출력 확인")
    @Test
    void checkResultMessage() {
        OutputView.printResultMessage();
        assertThat(output()).isEqualTo("실행 결과");
    }

    @DisplayName("자동차의 위치를 -를 사용하여 출력하는지")
    @Test
    void checkStatus() {
        OutputView.printStatus("pobi", 6);
        assertThat(output()).isEqualTo("pobi : ------");
    }

}
