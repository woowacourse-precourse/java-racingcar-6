package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoundPlayingTest {

    @Test
    void decideToMoveTest() {
        RoundPlaying judge = new RoundPlaying();
        int lowNumber = 2;
        int highNumber = 4;

        assertFalse(judge.decideToMove(lowNumber));
        assertTrue(judge.decideToMove(highNumber));
    }
}