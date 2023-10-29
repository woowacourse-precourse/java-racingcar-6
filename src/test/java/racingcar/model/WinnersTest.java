package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    public void createWinners_fail() {
        List<String> winnerNames = List.of("pobi", "pobi", "jun");
        assertThrows(IllegalArgumentException.class, () -> {
            Winners winners = new Winners(winnerNames);
        });
    }

    @Test
    public void getWinnerNames() {
        List<String> winnerNames = List.of("pobi", "woni", "jun");

        Winners winners = new Winners(winnerNames);

        List<String> realWinnerNames = winners.getWinnerNames();

        assertEquals(winnerNames, realWinnerNames);
    }
}