package racingcar.compare;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import racingcar.race.Compare;

import java.util.Arrays;
import java.util.List;

public class CompareTest {
    @Test
    void 최대값이_제대로_저장됨() {
        Compare compare = new Compare();
        List<Integer> list = Arrays.asList(1, 5, 2, 4, 4);
        int max = compare.saveMaxPosition(list);

        assertThat(max).isEqualTo(5);
    }
    @Test
    void 최대값의_개수_제대로_저장됨() {
        Compare compare = new Compare();
        List<Integer> list = Arrays.asList(1, 5, 4, 3, 5);
        int count = compare.findHowManyMax(list);

        assertThat(count).isEqualTo(2);
    }
    @Test
    void 최대값의_인덱스_제대로_저장됨() {
        Compare compare = new Compare();
        List<Integer> list = Arrays.asList(1, 5, 4, 3, 5);
        List<Integer> index = compare.findMaxIndex(list);

        assertThat(index).contains(1, 4);
    }
}
