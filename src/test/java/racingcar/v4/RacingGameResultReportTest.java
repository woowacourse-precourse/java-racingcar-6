package racingcar.v4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingGameResultReportTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    void printCarPositionWithName() {
        RacingGameResultReport report = new RacingGameResultReport();
        Map<String, Integer> racingStateMap = new HashMap<>();
        racingStateMap.put("페라리", 3);
        racingStateMap.put("벤츠", 2);
        racingStateMap.put("레드불", 5);

        report.printCarPositionWithName(racingStateMap);

        String expectedOutput = "페라리 : ---" + System.lineSeparator() +
                "벤츠 : --" + System.lineSeparator() +
                "레드불 : -----" + System.lineSeparator();

        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void announceWinners_단일우승() {
        RacingGameResultReport report = new RacingGameResultReport();
        Map<String, Integer> racingStateMap = new HashMap<>();
        racingStateMap.put("벤츠", 3);
        racingStateMap.put("페라리", 2);
        racingStateMap.put("레드불", 5);

        report.announceWinners(racingStateMap);

        String expectedOutput = "최종 우승자 : 레드불" + System.lineSeparator();

        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void announceWinners_공동우승() {
        RacingGameResultReport report = new RacingGameResultReport();
        Map<String, Integer> racingStateMap = new HashMap<>();
        racingStateMap.put("벤츠", 3);
        racingStateMap.put("페라리", 3);
        racingStateMap.put("레드불", 3);

        report.announceWinners(racingStateMap);

        String expectedOutput = "최종 우승자 : ";

        assertThat(outContent.toString()).contains(expectedOutput);

        List<String> winners = Arrays.asList("벤츠", "페라리", "레드불");
        for (String winner : winners) {
            assertThat(outContent.toString()).contains(winner);
        }
    }

}