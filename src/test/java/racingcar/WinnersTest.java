package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnersTest {
    @Test
    void 우승자_출력() {
        Winners winners = new Winners();
        winners.addWinners("A");
        winners.addWinners("B");
        winners.addWinners("C");

        assertEquals(winners.toString(), "A, B, C");

    }
}
