package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ConsoleOutputViewTest {
    ConsoleOutputView consoleOutputView = new ConsoleOutputView();

    @Test
    void showInputCarNamesPrompt() {
        String output = consoleOutputView.showInputCarNamesPrompt();
        assertEquals(output, "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void showInputTryNumberPrompt() {
        String output = consoleOutputView.showInputTryNumberPrompt();
        assertEquals(output, "시도할 회수는 몇회인가요?");
    }

    @Test
    void showExecutionResultsHeader() {
        String output = consoleOutputView.showExecutionResultsHeader();
        assertEquals(output, "실행 결과");
    }

    @Test
    void showExecutionResults() {
        ArrayList<String> carNames = new ArrayList<>(List.of("Tom", "Bob", "Lisa"));
        ArrayList<Integer> carGoingCount = new ArrayList<>(List.of(3, 5, 2));

        String output = consoleOutputView.showExecutionResults(carNames, carGoingCount);
        assertEquals(output, "Tom : ---\nBob : -----\nLisa : --\n");
    }

    @Test
    void showWinner() {
        String winners = "Bob";
        String output = consoleOutputView.showWinner(winners);
        assertEquals(output, "최종 우승자 : " + winners);
    }
}