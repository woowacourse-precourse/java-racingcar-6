package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


public class RaceTest {
    List<String> CAR_NAMES = Arrays.asList("Race", "Test");

    @Test
    void 올바른_Race_생성() {
        Race race = new Race(CAR_NAMES);

        assertThat(race)
                .isNotNull();
    }

    @Test
    void 시도_전_거리는_모두_0() {
        Race race = new Race(CAR_NAMES);

        for (String name : race.getCarNames()) {
            assertThat(race.getDistance(name))
                    .isEqualTo(0);
        }
    }

    @Test
    void 시도_후_거리_확인() {
        Race race = new Race(CAR_NAMES);
        race.doAttempt();
        race.doAttempt();

        for (String name : race.getCarNames()) {
            assertThat(race.getDistance(name))
                    .isBetween(0, 2);
        }
    }

}
