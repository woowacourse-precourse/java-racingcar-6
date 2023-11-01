package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceStartTest {
    private RaceStart raceStart;
    @BeforeEach
    void setUp() {
        raceStart = new RaceStart();
    }
    @Test
    void forwardDecisionTest() {
        //given
        Map<String, Integer> carTest = new LinkedHashMap<>(){{
           put("pobi", 0);
           put("woni", 0);
           put("jun", 0);
        }};

        //when
        for(String s : carTest.keySet()){
            raceStart.forwardDecision(carTest, 4, s);
        }

        //then
        assertThat(carTest).containsExactly(entry("pobi", 1), entry("woni", 1), entry("jun", 1));
    }

    @Test
    void 정지Test() {
        //given
        Map<String, Integer> carTest = new LinkedHashMap<>(){{
            put("pobi", 0);
            put("woni", 0);
            put("jun", 0);
        }};

        //when
        for(String s : carTest.keySet()){
            raceStart.forwardDecision(carTest, 3, s);
        }

        //then
        assertThat(carTest).containsExactly(entry("pobi", 0), entry("woni", 0), entry("jun", 0));
    }

    @Test
    void showResultTest() {
        //given
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Map<String, Integer> carTest = new LinkedHashMap<>(){{
            put("pobi", 1);
            put("woni", 2);
        }};

        //when
        raceStart.showResult(carTest);
        String outputMessage = outputStreamCaptor.toString().trim();

        //then
        String shouldOutputMessage = "pobi : -\nwoni : --";
        assertEquals(shouldOutputMessage, outputMessage);

        System.setOut(System.out);
    }
}
