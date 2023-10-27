package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RaceTest {
    private Race race = new Race();

    @Test
    void initialize() {
        ArrayList<String> carNames = new ArrayList<>(List.of("Car1", "Car2", "Car3"));

        race.initialize(carNames);

        ArrayList<String> resultCarNames = race.getCarNames();
        ArrayList<Integer> resultCarGoingCount = race.getCarGoingCount();

        // initialize 메서드가 예상대로 동작하는지 확인
        assertEquals(carNames, resultCarNames);
        assertEquals(carNames.size(), resultCarGoingCount.size());
    }

    @Test
    void runRace() {
        ArrayList<String> carNames = new ArrayList<>(List.of("Car1", "Car2", "Car3"));

        race.initialize(carNames);

        race.runRace();

        ArrayList<Integer> resultCarGoingCount = race.getCarGoingCount();

        // runRace 메서드가 예상대로 동작하는지 확인
        for (int count : resultCarGoingCount) {
            assertEquals(true, count >= 0 && count <= 1);
        }
    }

    @Test
    void getWinners() {
        ArrayList<String> carNames = new ArrayList<>(List.of("Car1", "Car2", "Car3"));

        race.initialize(carNames);

        ArrayList<Integer> carGoingCount = new ArrayList<>(List.of(1, 2, 2));

        for (int i = 0; i < carGoingCount.size(); i++) {
            race.getCarGoingCount().set(i, carGoingCount.get(i));
        }
        String winners = race.Winners();

        // getWinners 메서드가 예상대로 동작하는지 확인
        assertEquals("Car2, Car3", winners);
    }
}
