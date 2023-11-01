package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {
    private Winner winner;

    @BeforeEach
    void setUp() {
        winner = new Winner();
    }

    @Test
    @DisplayName("우승자가 한 명일 때")
    void testFindWinner() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        List<String> progressResults = List.of("--", "---", "-");

        List<String> expected = List.of("woni");
        List<String> result = winner.findWinners(carNames, progressResults);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("우승자가 두 명 이상일 때")
    void testFindWinners() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        List<String> progressResults = List.of("--", "---", "---");

        List<String> expected = List.of("woni", "jun");
        List<String> result = winner.findWinners(carNames, progressResults);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("진행 결과의 길이가 다른 경우 최대 길이 확인")
    void testFindMaxProgressWhenResultsHaveDifferentLengths() {
        List<String> progressResults = List.of("---", "--", "-");

        int expected = 3;
        int result = winner.findMaxProgress(progressResults);

        assertEquals(expected,result);
    }

    @Test
    @DisplayName("모든 진행 결과의 길이가 같은 경우 최대 길이 확인")
    void testFindMaxProgressWhenAllResultsHaveEqualLength() {
        List<String> progressResults = List.of("----", "--", "----");

        int expected = 4;
        int result = winner.findMaxProgress(progressResults);

        assertEquals(expected,result);
    }
}