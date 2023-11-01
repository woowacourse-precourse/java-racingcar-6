package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.util.RaceUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    void raceNumberTest() {
        String input = "5";
        int result = RaceUtil.raceNumber(input);
        assertThat(result).isEqualTo(5);
    }
}
