package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {

    @Test
    void testCheckWinner() {
        List<Car> carRace = new ArrayList<>();
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");
        pobi.position = 3;
        woni.position = 5;
        jun.position = 7;
        carRace.add(pobi);
        carRace.add(woni);
        carRace.add(jun);

        Winner.checkWinner(carRace);

        assertEquals(1, GameManager.winner.size());
    }
}