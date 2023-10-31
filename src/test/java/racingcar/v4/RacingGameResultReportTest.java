package racingcar.v4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

}