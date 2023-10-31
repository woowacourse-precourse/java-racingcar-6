package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


public class RaceTest {
    List<String> names = Arrays.asList("Race", "Test");
    int NUMBER_ATTEMPTS_VALID = 2;
    int NUMBER_ATTEMPTS_INVALID = -1;

    @Test
    void 올바른_Race_생성() {
        Race race = new Race(names, NUMBER_ATTEMPTS_VALID);
        assertThat(race)
                .isNotNull();
    }

    @Test
    void 시도횟수_음수_예외처리() {
        assertThatThrownBy(() -> { new Race(names, NUMBER_ATTEMPTS_INVALID); })
                .isInstanceOf(IllegalArgumentException.class);
    }

}
