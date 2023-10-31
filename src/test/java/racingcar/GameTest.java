package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class GameTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpForTest() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testPrintRaceResult() {
        Game testRace = new Game();
        ArrayList<Integer> testRaceResult = new ArrayList<>();
        testRaceResult.add(2);
        testRaceResult.add(4);
        ArrayListConverter listConverter = new ArrayListConverter();
        ArrayList<String> testCars = listConverter.carNameStringToArrayList("pobi, jun");

        testRace.printTotalLapResult(testRaceResult, testCars);

        assertThat(outputStreamCaptor.toString()).contains("pobi : --", "jun : ----");

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
