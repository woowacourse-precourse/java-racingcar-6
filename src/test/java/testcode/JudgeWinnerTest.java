package testcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.JudgeWinner;

public class JudgeWinnerTest {

    @Test
    @DisplayName("우승자 판정 테스트(단독)")
    public void soloWinnerTest() {
        int[] result = {3, 3, 2};
        List<String> members = new ArrayList<>(Arrays.asList("jack", "bob", "cars"));
        final JudgeWinner judgeWinner = new JudgeWinner(result, members);
        assertThat(judgeWinner.getWinner()).isEqualTo("jack,bob");
    }

    @Test
    @DisplayName("우승자 판정 테스트(공동)")
    public void dualWinnerTest() {
        int[] result = {1, 3, 1};
        List<String> members = new ArrayList<>(Arrays.asList("jack", "bob", "cars"));
        final JudgeWinner judgeWinner = new JudgeWinner(result, members);
        assertThat(judgeWinner.getWinner()).isEqualTo("bob");
    }
}
