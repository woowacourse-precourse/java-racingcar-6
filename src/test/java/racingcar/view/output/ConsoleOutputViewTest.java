package racingcar.view.output;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.PrintOutputTest;

public class ConsoleOutputViewTest extends PrintOutputTest {

    private ConsoleOutputView consoleOutputView;

    @BeforeEach
    protected final void initializeConsoleInputView() {
        consoleOutputView = new ConsoleOutputView();
    }

    @Test
    void 경주할_자동차_이름을_입력하는_메시지_출력() {
        final String expected = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        consoleOutputView.printInputCarNameMessage();
        assertThat(output()).contains(expected);
    }

    @Test
    void 시도할_회수를_물어보는_문구_출력() {
        final String expected = "시도할 회수는 몇회인가요?";
        consoleOutputView.printInputTryCountMessage();
        assertThat(output()).contains(expected);
    }

    @Test
    void 실행_결과_문구를_출력() {
        final String STRING_EXECUTION_RESULT = "실행 결과";
        consoleOutputView.printExecutionResult();
        assertThat(output()).contains(STRING_EXECUTION_RESULT);
    }
}
