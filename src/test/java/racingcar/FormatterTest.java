package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FormatterTest {

    private static final String CAR_NAMES = "pobi,woni,jun";
    private static final String ROUND = "5";

    @Test
    void formatCarNames() {
        List<String> formattedCarNames = Formatter.formatCarNames(CAR_NAMES);
        assertEquals(formattedCarNames.get(0), "pobi");
        assertEquals(formattedCarNames.get(1), "woni");
        assertEquals(formattedCarNames.get(2), "jun");
    }

    @Test
    void formatRound() {
        int round = Formatter.formatRound(ROUND);
        assertEquals(round, 5);
    }
}