package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceLogicTest {

    @Test
    void attemptAllRacer() {
        Racer[] racers = {new Racer("pobi"), new Racer("woni")};

        RaceLogic.attemptAllRacer(racers, true);

        assertEquals(1, racers[0].getProgress());
        assertEquals(1, racers[1].getProgress());
    }

    @Test
    void attemptOnceWithRacer() {
        Racer racer = new Racer("pobi");

        RaceLogic.attemptOnceWithRacer(racer, true);

        assertEquals(1, racer.getProgress());
    }

    @Test
    void findWinner() {
        Racer[] racers = {new Racer("pobi"), new Racer("woni")};
        racers[0].increaseProgress();
        racers[0].increaseProgress();
        racers[1].increaseProgress();

        List<Racer> winners = RaceLogic.findWinner(racers);

        assertEquals(1, winners.size());
        assertTrue(winners.contains(racers[0]));
    }
}