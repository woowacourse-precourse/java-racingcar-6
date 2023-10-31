package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultViewTest {
    private ByteArrayOutputStream outputStream;
    private List<String> winners;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        winners = new ArrayList<>();
    }
    @Test
    public void 우승자_1명_출력() {
        winners.add("Car1");

        ResultView.printResult(winners);

        System.setOut(System.out);

        String expectedOutput = "최종 우승자 : Car1";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    public void 우승자_2명_출력() {
        winners.add("Car1");
        winners.add("Car2");

        ResultView.printResult(winners);

        System.setOut(System.out);

        String expectedOutput = "최종 우승자 : Car1, Car2";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
}