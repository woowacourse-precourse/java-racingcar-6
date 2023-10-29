package mytest;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static view.OutputView.displayPlayResult;
import static view.OutputView.displayRaceResult;

public class RandomForwardTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void 레이스실행결과_테스트(){
        HashMap<String, Integer> raceResult = new HashMap<>();
        raceResult.put("a", 1);
        raceResult.put("b", 3);
        raceResult.put("c", 2);

        displayPlayResult();
        displayRaceResult(raceResult);

        String expectedOutput = "\n실행 결과\n" +
                "a : -\n" +
                "b : ---\n" +
                "c : --\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

}
