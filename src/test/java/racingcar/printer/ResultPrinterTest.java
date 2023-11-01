package racingcar.printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.evaluator.WinnerEvaluator;

import static org.assertj.core.api.Assertions.assertThat;

class ResultPrinterTest {

    private final WinnerEvaluator evaluator = new WinnerEvaluator();
    private final ResultPrinter printer = new ResultPrinter(evaluator);

    @Test
    @DisplayName("우승자들을 ,로 이어붙일 수 있다.")
    void buildWinner() {
        List<String> winners = new ArrayList<>(Arrays.asList("woo", "wa", "cour", "se"));
        String result = printer.buildWinner(winners);

        assertThat(result).isEqualTo("woo, wa, cour, se");
    }
}
