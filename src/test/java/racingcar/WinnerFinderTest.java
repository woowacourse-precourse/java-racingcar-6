package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinnerFinderTest {
    private WinnerFinder winnerFinder;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setup() {
        winnerFinder = new WinnerFinder();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void 최종_단일_우승자_선별() {
        List<String[]> cars = new ArrayList<>();
        cars.add(new String[]{"carA", "-"});
        cars.add(new String[]{"carB", "--"});
        cars.add(new String[]{"carC", "---"});

        winnerFinder.printWinner(cars);

        String expectedOutput = "최종 우승자 : carC\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void 최종_복수_우승자_선별() {
        List<String[]> cars = new ArrayList<>();
        cars.add(new String[]{"carA", "-"});
        cars.add(new String[]{"carB", "--"});
        cars.add(new String[]{"carC", "---"});
        cars.add(new String[]{"carD", "---"});

        winnerFinder.printWinner(cars);

        String expectedOutput = "최종 우승자 : carC, carD\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}