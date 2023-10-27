package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ConsoleOutputViewTest {
    @Test
    void showInputCarNamesPrompt() {
        ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        String output = consoleOutputView.showInputCarNamesPrompt();
        assertEquals(output, "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void showInputTryNumberPrompt() {
    }

    @Test
    void showExecutionResultsHeader() {
    }

    @Test
    void showExecutionResults() {
    }

    @Test
    void showWinner() {
    }
}