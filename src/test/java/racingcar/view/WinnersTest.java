package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.view.Winners.makeString;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnersTest {
    @Test
    void 여러명_우승() {
        List<String> inputs = Arrays.asList("abc", "de", "f");
        String winners = makeString(inputs);
        System.out.println(winners);
        assertThat(winners).isEqualTo("abc, de, f");
    }

    @Test
    void 한_명_우승() {
        List<String> inputs = Arrays.asList("abc");
        String winners = makeString(inputs);
        System.out.println(winners);
        assertThat(winners).isEqualTo("abc");
    }
}
