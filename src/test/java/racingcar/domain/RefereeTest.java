package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void 최종_우승자_선발_한명() {
        Referee referee = new Referee();
        List<String> inputCars = Arrays.asList("a", "b", "c");
        List<Integer> inputCarPos = Arrays.asList(1, 2, 3);

        List<String> winner = referee.findWinner(inputCars, inputCarPos);

        assertThat(winner).containsExactly("c");
    }

    @Test
    void 최종_우승자_선발_여러명() {
        Referee referee = new Referee();
        List<String> inputCars = Arrays.asList("a", "b", "c");
        List<Integer> inputCarPos = Arrays.asList(1, 3, 3);

        List<String> winner = referee.findWinner(inputCars, inputCarPos);

        assertThat(winner).containsExactly("b", "c");
    }

}
