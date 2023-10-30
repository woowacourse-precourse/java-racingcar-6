package racingcar.util;

import racingcar.util.SoleChampion;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoleChampionTest {

    @Test
    public void testFinalWinnerOutput() {
        SoleChampion soleChampion = new SoleChampion();

        List<String> winnerInformation = Arrays.asList("Car1", "Car2", "Car3");

        // Redirect System.out to capture the printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        soleChampion.finalWinnerOutput(winnerInformation);

        // Reset System.out
        System.setOut(System.out);

        // Verify the printed output with Windows-style line endings
        String expectedOutput = "Car1, Car2, Car3\r\n"; // Windows 스타일의 줄 바꿈 문자인 '\r\n' 사용
        assertEquals(expectedOutput, outputStream.toString());
    }
}
