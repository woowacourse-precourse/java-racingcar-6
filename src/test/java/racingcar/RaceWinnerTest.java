package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.RaceSimulator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RaceWinnerTest {

    @Test
    void 공동_우승() {
        LinkedHashMap<String, String> carResults = new LinkedHashMap<>();
        carResults.put("pobi", "------");
        carResults.put("woni", "------");
        carResults.put("jun", "----");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        RaceSimulator.raceWinner(carResults);

        String output = outputStream.toString().trim();
        assertEquals("최종 우승자 : pobi, woni", output);

    }
}
