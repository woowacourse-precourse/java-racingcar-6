package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    @Test
    void decisionWinner_단독우승자_결정() {
        Winner winner = new Winner();
        List<Integer> inputTrack = Arrays.asList(5, 3, 3);
        int testBestRecord = winner.calculateBestRecord(inputTrack);
        List<Integer> result = winner.findWinnerindex(inputTrack, testBestRecord);
        assertThat(result).containsExactly(0);
    }

    @Test
    void decisionWinner_공동우승자_결정() {
        Winner winner = new Winner();
        List<Integer> inputTrack = Arrays.asList(5, 5, 3);
        int testBestRecord = winner.calculateBestRecord(inputTrack);
        List<Integer> result = winner.findWinnerindex(inputTrack, testBestRecord);
        assertThat(result).containsExactly(0, 1);
    }

    @Test
    void decisonWinner_아무도_앞으로_가지_못한_경우() {
        Winner winner = new Winner();
        List<Integer> inputTrack = Arrays.asList(0, 0, 0);
        int testBestRecord = winner.calculateBestRecord(inputTrack);
        List<Integer> result = winner.findWinnerindex(inputTrack, testBestRecord);
        assertThat(result).containsExactly(0, 1, 2);
    }
}
