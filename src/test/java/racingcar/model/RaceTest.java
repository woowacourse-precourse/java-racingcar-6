package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    @Test
    void 경주() {
        Race race = new Race();
        List<String> result = race.racingCar(3, Arrays.asList("aa", "bb", "cc"));

        for (int i = 0; i < result.size(); i++) {
            assertThat(Arrays.asList("aa", "bb", "cc")).contains(result.get(i));
        }
    }

    @Test
    void 우승자_찾기_단독_우승() {
        Race race = new Race();
        List<String> result = race.findingWinner(Arrays.asList("pobi", "jun"), Arrays.asList(1, 2));
        assertThat(result).isEqualTo(Arrays.asList("jun"));

    }

    @Test
    void 우승자_찾기_공동_우승() {
        Race race = new Race();
        List<String> result = race.findingWinner(Arrays.asList("pobi", "jun", "woni"), Arrays.asList(1, 2, 2));
        assertThat(result).isEqualTo(Arrays.asList("jun", "woni"));

    }

}