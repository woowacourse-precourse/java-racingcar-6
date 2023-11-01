package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgementTest {

    @Test
    void decideToMoveTest() {
        Judgement judge = new Judgement();
        int lowNumber = 2;
        int highNumber = 4;

        assertFalse(judge.decideToMove(lowNumber));
        assertTrue(judge.decideToMove(highNumber));
    }
}