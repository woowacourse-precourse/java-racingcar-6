package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RaceTest {
    private Race race = new Race();

    @Test
    void initialize() {
        // given
        ArrayList<String> carNames = new ArrayList<>(List.of("Car1", "Car2", "Car3"));

        // when
        race.initialize(carNames);

        // then
        assertThat(carNames).containsExactly("Car1", "Car2", "Car3");
        assertThat(race.getCarGoingCount()).containsExactly(0, 0, 0);
    }

    @Test
    void runRace() {
        // given
        ArrayList<String> carNames = new ArrayList<>(List.of("Car1", "Car2", "Car3"));
        race.initialize(carNames);

        // when
        race.runRace();
        ArrayList<Integer> resultCarGoingCount = race.getCarGoingCount();

        // then
        for (int count : resultCarGoingCount) {
            assertTrue(count >= 0 && count <= 1);
        }
    }

    @Test
    void winners() {
        // given
        ArrayList<String> carNames = new ArrayList<>(List.of("Car1", "Car2", "Car3"));
        race.initialize(carNames);
        ArrayList<Integer> carGoingCount = new ArrayList<>(List.of(1, 2, 2));

        // when
        for (int i = 0; i < carGoingCount.size(); i++) {
            race.getCarGoingCount().set(i, carGoingCount.get(i));
        }
        String winners = race.winners();

        // then
        assertThat("Car2, Car3").isEqualTo(winners);
    }
}
