package racingcar.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.config.GameMessages;
import racingcar.domain.Car;
import racingcar.dto.CarStateDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.RoundResultDto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class OutputManagerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private OutputManager outputManager = new OutputManager();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrintCarNameInputMessage() {
        outputManager.printCarNameInputMessage();
        assertEquals(GameMessages.INPUT_CAR_NAME + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testPrintTryCountInputMessage() {
        outputManager.printTryCountInputMessage();
        assertEquals(GameMessages.INPUT_TRY_COUNT + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testPrintExecutionResultMessage() {
        outputManager.printExecutionResultMessage();
        assertEquals(GameMessages.EXECUTION_RESULT + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testPrintRoundResult() {
        RoundResultDto roundResultDto = new RoundResultDto(Arrays.asList(
                new CarStateDto(new Car("car1", 4)),
                new CarStateDto(new Car("car2", 2))
        ));
        outputManager.printRoundResult(roundResultDto);
        String expectedOutput = "car1 : ----" + System.lineSeparator() + "car2 : --" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintFinalWinner() {
        GameResultDto gameResultDto = new GameResultDto(Collections.singletonList("car1"));
        outputManager.printFinalWinner(gameResultDto);
        assertEquals(GameMessages.FINAL_WINNER + "car1" + System.lineSeparator(), outContent.toString());
    }
}
