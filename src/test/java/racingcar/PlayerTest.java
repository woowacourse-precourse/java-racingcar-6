package racingcar;

import racingcar.domain.Player;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RandomGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("TestPlayer");
    }

    @Test
    void testRunWithRandomNumAboveThreshold() {
        // Mocking the random number generator
        Randoms randoms = mock(Randoms.class);
        when(randoms.pickNumberInRange(0, 9)).thenReturn(5); // Forcing a random number above the threshold

        // Setting the mocked random number generator to the Player object
        // Player.setRandomGenerator(randoms);

        // Running the player
        player.run();

        // The player's run count should increase by 1
        assertEquals(1, player.getRunCount());
    }

    @Test
    void testRunWithRandomNumBelowThreshold() {
        // Mocking the random number generator
        RandomGenerator randoms = mock(RandomGenerator.class);
        when(randoms.randomNumberInRange(0, 9)).thenReturn(3); // Forcing a random number below the threshold

        // Running the player
        player.run();

        // The player's run count should remain the same
        assertEquals(0, player.getRunCount());
    }

    @Test
    void testPrintRunCount() {
        // Set run count to 3
        player.setRunCount(3);

        // Expected output for 3 runs
        StringBuilder expected = new StringBuilder();
        expected.append("TestPlayer : ---");

        //assertEquals(expected.toString(), player.getRunCountString());
    }
}
