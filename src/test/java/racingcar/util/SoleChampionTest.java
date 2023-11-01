package racingcar.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SoleChampionTest {

    @Test
    public void testFinalWinnerOutput() {

        SoleChampion soleChampion = new SoleChampion();
        List<String> winnerInformation = Arrays.asList("Car1", "Car2", "Car3");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStream));
        soleChampion.finalWinnerOutput(winnerInformation);
        System.setOut(System.out);
        String expectedOutput = "Car1, Car2, Car3\r\n";

        Assertions.assertThat(expectedOutput).isEqualTo(outputStream.toString());

    }
}
