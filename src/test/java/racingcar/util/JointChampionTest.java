package racingcar.util;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JointChampionTest {

    @Test
    public void testFinalWinnerOutput() {
        JointChampion jointChampion = new JointChampion();

        List<String> winnerInformation = Arrays.asList("Car1", "Car2", "Car3");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStream));
        jointChampion.finalWinnerOutput(winnerInformation);
        System.setOut(System.out);
        String expectedOutput = "Car1, Car2, Car3\r\n";

        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }
}
