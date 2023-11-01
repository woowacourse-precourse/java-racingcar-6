package study;

import org.junit.jupiter.api.Test;
import racingcar.Application;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayResultTest {

    @Test
    void testDisplayResult() {
        Application carRace = new Application();
        carRace.carNamesList.add("Car1");
        carRace.carNamesList.add("Car2");
        carRace.scoreList.add(2);
        carRace.scoreList.add(3);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        carRace.displayResult();

        String expectedOutput = "Car1 : --\nCar2 : ---\n\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
