package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WinnerTest {


    @Test
    void createWinner_success() {
        String winnerName = "pobi";
        Winner winner = new Winner(winnerName);

        assertEquals(winnerName, winner.getName());
    }

    @Test
    void createWinner_fail_invalid_name_length() {
        String winnerName = "pobiiii";

        assertThrows(IllegalArgumentException.class, () -> {
            Winner winner = new Winner(winnerName);
        });
    }

    @Test
    void createWinner_fail_empty_name() {
        String winnerName = "";

        assertThrows(IllegalArgumentException.class, () -> {
            Winner winner = new Winner(winnerName);
        });
    }
}