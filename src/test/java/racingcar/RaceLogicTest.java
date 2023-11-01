package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceLogicTest {

    @Test
    void attemptAllRacer() {
    }

    @Test
    void attemptOnceWithRacer() {
        Racer racer = new Racer("pobi");

        RaceLogic.attemptOnceWithRacer(racer);

        assertEquals(1, racer.getProgress());
    }

    @Test
    void findWinner() {
    }
}