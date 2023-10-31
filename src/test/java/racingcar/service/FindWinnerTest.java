package racingcar.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FindWinnerTest {

    @Test
    void 최대값_찾기() {
        FindWinner findWinner = new FindWinner();
        List<Integer> moveInfo = new ArrayList<>(List.of(2, 3, 5, 5, 4));
        int result = findWinner.findMax(moveInfo);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 우승자_찾기() {
        FindWinner findWinner = new FindWinner();
        List<Integer> moveInfo = new ArrayList<>(List.of(2, 3, 5, 5, 4));
        List<String> cars = new ArrayList<>(List.of("car1", "car2", "car3", "car4", "car5"));

        List<String> cmp = new ArrayList<>(List.of("car3", "car4"));
        List<String> result = findWinner.getWinnerInfo(moveInfo, cars);
        assertThat(result).isEqualTo(cmp);
    }
}