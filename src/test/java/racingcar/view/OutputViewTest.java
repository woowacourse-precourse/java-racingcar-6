package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    @Test
    void showExecutionResultsHeader() {
        String output = OutputView.showExecutionResultsHeader();
        assertEquals(output, "실행 결과");
    }

    @Test
    void showExecutionResults() {
        ArrayList<String> carNames = new ArrayList<>(List.of("Tom", "Bob", "Lisa"));
        ArrayList<Integer> carGoingCount = new ArrayList<>(List.of(3, 5, 2));

        String output = OutputView.showExecutionResults(carNames, carGoingCount);
        assertEquals(output, "Tom : ---\nBob : -----\nLisa : --\n");
    }

    @Test
    void showWinner() {
        String winners = "Bob";
        String output = OutputView.showWinner(winners);
        assertEquals(output, "최종 우승자 : " + winners);
    }
}