package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MyApplicationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testListConversion() {
        String racingCar = "pobi,man";

        List<String> expected = new ArrayList<>();
        expected.add("pobi");
        expected.add("man");

        List<String> result = Application.listConversion(racingCar);

        assertIterableEquals(expected, result);
    }

    @Test
    void testIsValidNum_ValidInput() {
        String validInput = "10";

        boolean isValid = Application.isValidNum(validInput);

        assertTrue(isValid);
    }

    @Test
    void testForward() {
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");

        int gameNum = 5;

        List<String>[] forwardResults = Application.forward(carNames, gameNum);

        assertNotNull(forwardResults);
        assertEquals(carNames.size(), forwardResults.length);

        for (int i = 0; i < forwardResults.length; i++) {
            List<String> forwardList = forwardResults[i];
            assertNotNull(forwardList);
            assertEquals(gameNum, forwardList.size());

            for (String forward : forwardList) {
                assertTrue(forward.matches("^-*$"));
            }
        }
    }

    @Test
    void testPrintWinner() {
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");

        int gameNum = 5;

        List<String>[] forwardResults = new ArrayList[carNames.size()];
        for (int i = 0; i < carNames.size(); i++) {
            forwardResults[i] = new ArrayList<>();
            forwardResults[i].add("---");
            forwardResults[i].add("----");
            forwardResults[i].add("----");
            forwardResults[i].add("--");
            forwardResults[i].add("-");
        }

        Application.printWinner(carNames, gameNum, forwardResults);

        String expectedOutput = "최종 우승자 : car1, car2\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
