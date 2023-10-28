package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    private OutputView outputView;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach()
    void setEach(){
        outputView = new OutputView();
        System.setOut(new PrintStream(out));
    }

    @Test
    void test_Game_Start() {

        outputView.printStarting();
        outputView.printTimes();
        assertThat("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\r\n시도할 회수는 몇회인가요?\r\n").isEqualTo(out.toString());

    }

}
