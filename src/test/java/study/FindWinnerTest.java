package study;

import org.junit.jupiter.api.Test;
import racingcar.Application;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindWinnerTest {

    @Test
    void testFindWinner() {
        Application carRace = new Application();
        carRace.carNamesList.add("Car1");
        carRace.carNamesList.add("Car2");
        carRace.carNamesList.add("Car3");
        carRace.scoreList.add(2);
        carRace.scoreList.add(4);
        carRace.scoreList.add(4);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        carRace.findWinner();

        String expectedOutput = "최종 우승자 : Car2,Car3\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
