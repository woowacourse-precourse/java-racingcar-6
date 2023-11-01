package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.race.RaceService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RaceServiceTest {
    private final String[] carNames = {"car1", "car2", "car3"};
    private RaceService raceService;

    @BeforeEach
    void setUp() {
        raceService = new RaceService();
    }

    @Test
    void initializeCarsTest() {
        raceService.initializeCars(carNames);
        assertEquals(3, raceService.getCars().size());
    }

    @Test
    void checkValidNameTest() {
        String[] invalidCarNames = {"car", "car0", "car1234"};

        assertThrows(IllegalArgumentException.class, () -> {
            raceService.initializeCars(invalidCarNames);
        });
    }

    @Test
    void playRacesTest() {
        raceService.initializeCars(carNames);

        String result = raceService.playRaces(5);

        assertTrue(result.contains("실행 결과"));
    }

    @Test
    void getWinnerTest() {
        raceService.initializeCars(carNames);

        String winner = raceService.getWinner();

        assertTrue(winner.contains("최종 우승자"));
    }

}
