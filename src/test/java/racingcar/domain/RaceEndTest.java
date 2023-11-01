package racingcar.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceEndTest {
    private RaceEnd raceEnd;
    @BeforeEach
    void setUp() {
        raceEnd = new RaceEnd();
    }

    @Test
    void winnerResultTest() {
        //given
        Map<String, Integer> carTest = new LinkedHashMap<>(){{
            put("pobi", 0);
            put("woni", 3);
            put("jun", 10);
        }};

        StringBuilder sbExpected = new StringBuilder();
        sbExpected.append("jun");

        //when
        StringBuilder sbResult = new StringBuilder();
        sbResult.append(raceEnd.winnerResult(carTest));

        //then
        assertEquals(sbExpected.toString(), sbResult.toString());
    }

    @Test
    void 공동우승() {
        Map<String, Integer> carTest = new LinkedHashMap<>(){{
            put("pobi", 3);
            put("woni", 3);
        }};

        StringBuilder sbExpected = new StringBuilder();
        sbExpected.append("pobi, woni");

        //when
        StringBuilder sbResult = new StringBuilder();
        sbResult.append(raceEnd.winnerResult(carTest));

        //then
        assertEquals(sbExpected.toString(), sbResult.toString());
    }
}
