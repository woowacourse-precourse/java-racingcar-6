package racingcar.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.entity.Car;

public class RacingGameTest {

    @Test
    void testIsFinished() {
        int trial = 5;

        RacingGame racingGame = new RacingGame(List.of("aaa", "bbb"), trial);

        for (int i = 0; i < trial; i++) {
            assertNotEquals(true, racingGame.isFinished());
            racingGame.tryToProceedCars();
        }

        assertEquals(true, racingGame.isFinished());
    }

    @Test
    void testGetWinners_nullUntilFinished() {
        int trial = 5;

        RacingGame racingGame = new RacingGame(List.of("aaa", "bbb"), trial);

        for (int i = 0; i < trial; i++) {
            assertNull(racingGame.getWinners());
            racingGame.tryToProceedCars();
        }

        List<String> winners = racingGame.getWinners();

        assertTrue(winners instanceof List<String>);
        assertFalse(winners.isEmpty());
    }
}
