package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerChekerTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("올바른 최종 승리자를 출력하는지 확인한다.")
    public void testResult() {
        WinnerChecker winnerChecker = new WinnerChecker();
        List<String> members = Arrays.asList("poni", "woni", "jun");
        List<Integer> count = Arrays.asList(3, 4, 4);
        winnerChecker.checkWinner(members, count);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("최종 우승자 : woni, jun");
    }
}
