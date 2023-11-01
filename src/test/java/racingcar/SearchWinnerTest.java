package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SearchWinnerTest {

    @Test
    void 승자_찾기() {
        // Given
        List<String> carList = Arrays.asList("pobi -", "woni --", "crong", "jason ---");

        // When
        List<String> winners = SearchWinner.winnerSearch(carList);

        // Then
        List<String> expectedWinners = Arrays.asList("jason ---");

        assertThat(winners).isEqualTo(expectedWinners);
    }
}
