package racingcar;

import racingcar.View.InputView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class InputViewTest {
    private InputView iv;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUP(){
        iv = new InputView();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 이름안내출력확인(){
        String expected = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
        iv.printStartGuideMessage();
        assertThat(outputStreamCaptor.toString()).isEqualTo(expected);
    }

    @Test
    void 라운드안내출력확인(){
        String expected = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
        iv.printRoundGuideMessage();
        assertThat(outputStreamCaptor.toString()).isEqualTo(expected);
    }

}
