package racingcar.v4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameResultReportTest {
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(originalOut);
        try {
            outContent.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void printCarPositionWithName() {
        // 테스트 대상 메소드 실행
        RacingGameResultReport report = new RacingGameResultReport();
        Map<String, Integer> racingStateMap = new LinkedHashMap<>();
        racingStateMap.put("벤츠", 1);
        racingStateMap.put("레드불", 3);
        racingStateMap.put("페라리", 2);
        report.printCarPositionWithName(racingStateMap);

        // 테스트 결과 확인
        String expected = "벤츠 : -\n" +
                "레드불 : ---\n" +
                "페라리 : --\n\n";
        Assertions.assertThat(outContent.toString()).isEqualTo(expected);
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