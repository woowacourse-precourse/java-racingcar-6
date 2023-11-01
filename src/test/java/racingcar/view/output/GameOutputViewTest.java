package racingcar.view.output;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameOutputViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    void printRaceStart() {
        GameOutputView.printRaceStart();
        Assertions.assertEquals("실행 결과", outContent.toString().trim());
    }

    @Test
    void printGameResult() {
        GameOutputView.printGameResult("bodi, domo");
        Assertions.assertEquals("최종 우승자 : bodi, domo", outContent.toString().trim());
    }

    @Test
    void printGameProceeding() {
        GameOutputView.printGameProceeding("pobi", 2);
        Assertions.assertEquals("pobi : --", outContent.toString().trim());
    }

    @Test
    void printGapLine() {
        GameOutputView.printGapLine();
        Assertions.assertEquals("", outContent.toString().trim());
    }
}