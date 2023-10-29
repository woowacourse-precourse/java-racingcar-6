package racingcar.evaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrintWinnerTest {

    private final PrintWinner printWinner = new PrintWinner();

    @Test
    @DisplayName("우승자 List를 String 형태로 변경할 수 있다.")
    void buildWinner() {
        List<String> winners = new ArrayList<>(Arrays.asList("woo", "wa"));
        String winnersString = printWinner.buildWinner(winners);
        String[] winner = winnersString.split(", ");

        assertAll(
                () -> assertThat(winner[0]).isEqualTo(winners.get(0)),
                () -> assertThat(winner[1]).isEqualTo(winners.get(1))
        );
    }
}
