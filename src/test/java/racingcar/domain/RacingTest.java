package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingTest {
    private Racing racing;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        racing = new Racing();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void 하이퍼추가_여부결정() {
        String result1 = racing.addRacingOutput("", "-");
        String result2 = racing.addRacingOutput("", "0");

        assertEquals("-", result1);
        assertEquals("", result2);
    }


    @Test
    public void 우승자_명단_출력() {
        List<String> carNames = Arrays.asList("vea", "dare", "aser");
        String[] carStates = {"--0-", "----", "--00"};

        racing.winNameOutput(carNames, carStates);

        String expectedOutput = "최종 우승자 : dare";
        assertEquals(expectedOutput, outContent.toString().trim());

        outContent.reset();

        carStates = new String[]{"----", "----", "----"};
        racing.winNameOutput(carNames, carStates);

        expectedOutput = "최종 우승자 : Car1, Car2, Car3";
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}