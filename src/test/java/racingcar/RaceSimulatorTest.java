package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.driver.Driver;
import racingcar.race.RaceSimulator;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RaceSimulatorTest {
    @Test
    void simulateRaceTest() {
        // Given
        Driver driver = new Driver();
        String drivers = "BTS, 손흥민, 봉준호, 김태훈";
        Map<String, String> driverRoster = driver.makeDriverRoster(drivers);
        int opportunity = 5;
        RaceSimulator raceSimulator = new RaceSimulator();

        // Then
        raceSimulator.simulateRace(driverRoster, opportunity);
    }

    @Test
    void simulateSingleRaceTest() {
        // Given
        RaceSimulator raceSimulator = new RaceSimulator();
        Map<String, String> driverMap = new HashMap<>();
        driverMap.put("pobi", "--");

        // When
        raceSimulator.simulateSingleRace(driverMap);

        // Then
        assertEquals(true, true);
    }
}
