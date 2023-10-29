package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private OutputView outputView = new OutputView();

    @Test
    void showExecutionResultsHeader() {
        //when
        String output = outputView.showExecutionResultsHeader();

        //then
        assertThat(output).isEqualTo("실행 결과");
    }

    @Test
    void showExecutionResults() {
        //given
        ArrayList<String> carNames = new ArrayList<>(List.of("Tom", "Bob", "Lisa"));
        ArrayList<Integer> carGoingCount = new ArrayList<>(List.of(3, 5, 2));

        //when
        String output = outputView.showExecutionResults(carNames, carGoingCount);

        //then
        assertThat(output).isEqualTo("Tom : ---\nBob : -----\nLisa : --\n");
    }

    @Test
    void showWinner() {
        //given
        String winners = "Bob";

        //when
        String output = outputView.showWinner(winners);

        //then
        assertThat(output).isEqualTo("최종 우승자 : " + winners);
    }
}