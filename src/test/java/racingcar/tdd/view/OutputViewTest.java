package racingcar.tdd.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    private void doTest(String message) {
        assertThat(output.toString()).isEqualTo(message);
        System.setOut(System.out);
        output.reset();
    }


    @Test
    void 올바른_자동차_입력_메시지_출력시_통과() {
        String message = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";

        setUpStreams();
        OutputView.printCarNameInputMessage();
        doTest(message);
    }
    @Test
    void 올바른_자동차_입력_요구_메시지_출력시_통과() {
        String message = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";

        setUpStreams();
        OutputView.printCarNameInputMessage();
        doTest(message);
    }
    @Test
    void 올바른_시도_횟수_입력_메시지_출력시_통과() {
        String message = "시도할 회수는 몇회인가요?\n";

        setUpStreams();
        OutputView.printAttemptCountInputMessage();
        doTest(message);
    }

    @Test
    void 올바른_실행_결과_메시지_출력시_통과() {
        String message = "실행 결과\n";

        setUpStreams();
        OutputView.printGameResultMessage();
        doTest(message);
    }
}
