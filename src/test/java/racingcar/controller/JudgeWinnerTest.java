package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Tests class JudgeWinner method function correctly
 */
class JudgeWinnerTest {

    /**
     * Tests method judgeWinner if the winner number is only one
     */
    @Test
    void judge1WinnerTest() {
        // given
        LinkedHashMap<String, Integer> userCarDistance = new LinkedHashMap<String, Integer>();
        userCarDistance.put("poby", 20);
        userCarDistance.put("woni", 10);
        userCarDistance.put("jun", 10);

        List<String> expectedWinners = new ArrayList<>();
        expectedWinners.add("poby");

        // when
        List<String> actualWinners = JudgeWinner.judgeWinner(userCarDistance);

        // then
        assertThat(actualWinners).isEqualTo(expectedWinners);
    }

    /**
     * Tests method judgeWinner if the winner number is two
     */
    @Test
    void judge2WinnerTest() {
        // given
        LinkedHashMap<String, Integer> userCarDistance = new LinkedHashMap<String, Integer>();
        userCarDistance.put("poby", 20);
        userCarDistance.put("woni", 10);
        userCarDistance.put("jun", 20);

        List<String> expectedWinners = new ArrayList<>();
        expectedWinners.add("poby");
        expectedWinners.add("jun");

        // when
        List<String> actualWinners = JudgeWinner.judgeWinner(userCarDistance);

        // then
        assertThat(actualWinners).isEqualTo(expectedWinners);
    }

    /**
     * Tests method judgeWinner if the all is winner
     */
    @Test
    void judge3WinnerTest() {
        // given
        LinkedHashMap<String, Integer> userCarDistance = new LinkedHashMap<String, Integer>();
        userCarDistance.put("poby", 20);
        userCarDistance.put("woni", 20);
        userCarDistance.put("jun", 20);

        List<String> expectedWinners = new ArrayList<>();
        expectedWinners.add("poby");
        expectedWinners.add("woni");
        expectedWinners.add("jun");

        // when
        List<String> actualWinners = JudgeWinner.judgeWinner(userCarDistance);

        // then
        assertThat(actualWinners).isEqualTo(expectedWinners);
    }
}