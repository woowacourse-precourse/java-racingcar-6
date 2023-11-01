package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerTest {
    @Test
    void getWinnerCarNamesTest() {
        List<String> winnerNames = new ArrayList<>();
        winnerNames.add("pobi");
        winnerNames.add("woni");

        Winner winner = new Winner(winnerNames);

        assertEquals("pobi, woni", winner.getWinnerCarNames());
    }
}