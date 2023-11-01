package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class OutputManagerTest {
    ByteArrayOutputStream outputStream;
    OutputManager outputManager;

    @BeforeEach
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputManager = new OutputManager();
    }

    @Test
    void printCarStatus_success() {
        // Given
        Map<String, Integer> carStatus = new LinkedHashMap<>();
        carStatus.put("pobi", 2);
        carStatus.put("woni", 4);
        carStatus.put("jun", 3);

        // When
        outputManager.printCarStatus(carStatus);
        System.setOut(System.out);

        // Then
        String actualOutput = outputStream.toString().trim();
        String expectedOutput = "pobi : --\n" +
                "woni : ----\n" +
                "jun : ---";
        expectedOutput = expectedOutput.replace("\n", System.lineSeparator());
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}