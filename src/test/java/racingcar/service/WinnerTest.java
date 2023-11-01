package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnerTest {
    Winner winner = new Winner();

    @Test
    void 우승_자동차_목록을_전달() {
        List<Integer> carDistance = new ArrayList<>(Arrays.asList(0, 1));
        List<String> nameList = new ArrayList<>(Arrays.asList("star", "moon"));
        winner.carCompare(carDistance);
        
        List<String> result = new ArrayList<>(Arrays.asList("moon"));
        assertThat(winner.findWinner(nameList, carDistance)).isEqualTo(result);
    }
}
