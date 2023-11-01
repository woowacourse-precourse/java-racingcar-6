package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

class JudgeWinnerTest {
    @Test
    void judge1WinnerTest() {
        LinkedHashMap<String, Integer> userCarDistance = new LinkedHashMap<String, Integer>();
        userCarDistance.put("poby", 20);
        userCarDistance.put("woni", 10);
        userCarDistance.put("jun", 10);

        List<String> expectedWinners = new ArrayList<>();
        expectedWinners.add("poby");

        List<String> winners = JudgeWinner.judgeWinner(userCarDistance);
        assertThat(expectedWinners).isEqualTo(winners);
    }

    @Test
    void judge2WinnerTest() {
        LinkedHashMap<String, Integer> userCarDistance = new LinkedHashMap<String, Integer>();
        userCarDistance.put("poby", 20);
        userCarDistance.put("woni", 10);
        userCarDistance.put("jun", 20);

        List<String> expectedWinners = new ArrayList<>();
        expectedWinners.add("poby");
        expectedWinners.add("jun");

        List<String> winners = JudgeWinner.judgeWinner(userCarDistance);
        assertThat(expectedWinners).isEqualTo(winners);
    }

    @Test
    void judge3WinnerTest() {
        LinkedHashMap<String, Integer> userCarDistance = new LinkedHashMap<String, Integer>();
        userCarDistance.put("poby", 20);
        userCarDistance.put("woni", 20);
        userCarDistance.put("jun", 20);

        List<String> expectedWinners = new ArrayList<>();
        expectedWinners.add("poby");
        expectedWinners.add("woni");
        expectedWinners.add("jun");

        List<String> winners = JudgeWinner.judgeWinner(userCarDistance);
        assertThat(expectedWinners).isEqualTo(winners);
    }
}