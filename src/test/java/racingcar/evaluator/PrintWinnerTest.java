package racingcar.evaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.printer.ResultPrinter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrintWinnerTest {

    private final WinnerEvaluator evaluator = new WinnerEvaluator();
    private final ResultPrinter printer = new ResultPrinter(evaluator);

    @Test
    @DisplayName("우승자 List를 String 형태로 변경할 수 있다.")
    void buildWinner() {
        List<String> winners = new ArrayList<>(Arrays.asList("woo", "wa"));
        String winnersString = printer.buildWinner(winners);
        String[] winner = winnersString.split(", ");

        assertAll(
                () -> assertThat(winner[0]).isEqualTo(winners.get(0)),
                () -> assertThat(winner[1]).isEqualTo(winners.get(1))
        );
    }
}
