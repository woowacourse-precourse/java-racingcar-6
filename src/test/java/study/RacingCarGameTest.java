package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.RacingCarGame.compareResults;
import static racingcar.RacingCarGame.generateHyphens;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.UserInput;

public class RacingCarGameTest {

    @Test
    void compareResultsTest_onePlayer() {
        List<Integer> distance = new ArrayList<>();
        distance.add(2);
        List<Integer> maxIndex = compareResults(distance);
        assertThat(maxIndex.size()).isEqualTo(1);
        assertThat(maxIndex.get(0)).isEqualTo(0);
    }

    @Test
    void compareResultsTest_multiplePlayer() {
        List<Integer> distance = new ArrayList<>();
        distance.add(2);
        distance.add(2);
        distance.add(3);
        distance.add(3);
        distance.add(3);
        List<Integer> maxIndex = compareResults(distance);
        assertThat(maxIndex.size()).isEqualTo(3);
        assertThat(maxIndex.get(0)).isEqualTo(2);
        assertThat(maxIndex.get(1)).isEqualTo(3);
        assertThat(maxIndex.get(2)).isEqualTo(4);
    }

    @Test
    void generateHyphensTest() {
        String result = generateHyphens(10);
        assertThat(result).isEqualTo("----------");
    }

    @Test
    void receiveUserInputExceptionTest() {
        UserInput userInput = new UserInput();
        userInput.carNames.add("abcdefffff");
        assertThatThrownBy(() -> userInput.handleException())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("String index out of range: 5");
    }

}
