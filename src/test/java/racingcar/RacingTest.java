package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.race.Racing;

import java.util.Arrays;
import java.util.List;

class RacingTest {

    @Test
    void generateRaceStatusTest() {
        // Given
        Racing racing = new Racing();
        int passedLaps = 3;

        // When
        String result = racing.generateRaceStatus(passedLaps);

        // Then
        System.out.println(result);
    }

    @Test
    void generateRaceStatusForAllDriversTest() {
        // Given
        Racing racing = new Racing();
        List<String> driverList = Arrays.asList("BTS", "손흥민", "봉준호", "김태훈");
        int passedLaps = 3;

        // When
        String result = racing.generateRaceStatusForAllDrivers(driverList, passedLaps);

        // Then
        System.out.println(result);
    }

    @Test
    void showRaceResultTest() {
        // Given
        Racing racing = new Racing();
        List<String> driverList = Arrays.asList("BTS", "손흥민", "봉준호", "김태훈");
        int lapsToDrive = 5;

        // Then
        racing.showRaceResult(driverList, lapsToDrive);

    }
}
