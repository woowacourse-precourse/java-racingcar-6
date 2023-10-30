package racingcar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputProcessorTest {

    @Test
    public void testCarNameInputProcess() {
        String validInput = "pobi,woni,jun";
        assertDoesNotThrow(() -> InputProcessor.carNameInputProcess(validInput));

        String invalidInput = "pobi,woni,junnnnnnn";
        StringIndexOutOfBoundsException exception = assertThrows(StringIndexOutOfBoundsException.class,
                () -> InputProcessor.carNameInputProcess(invalidInput));
        assertEquals("String index out of range: 5 \nerrorVar : junnnnnnn", exception.getMessage());

        String emptyInput = "";
        NullPointerException nullPointerException = assertThrows(NullPointerException.class,
                () -> InputProcessor.carNameInputProcess(emptyInput));
        assertEquals("String is null or empty. \nerrorVar : ", nullPointerException.getMessage());
    }

    @Test
    public void testTryCountInputProcess() {
        String validInput = "5";
        assertDoesNotThrow(() -> InputProcessor.tryCountInputProcess(validInput));

        String invalidInput = "0";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputProcessor.tryCountInputProcess(invalidInput));
        assertEquals("Try count must be greater than 0. \nerrorVar : 0", exception.getMessage());

        String nonNumericInput = "abc";
        NumberFormatException numberFormatException = assertThrows(NumberFormatException.class,
                () -> InputProcessor.tryCountInputProcess(nonNumericInput));
        assertEquals("Invalid number format. \nerrorVar : abc", numberFormatException.getMessage());

        String emptyInput = "";
        NullPointerException nullPointerException = assertThrows(NullPointerException.class,
                () -> InputProcessor.carNameInputProcess(emptyInput));
        assertEquals("String is null or empty. \nerrorVar : ", nullPointerException.getMessage());
    }
}
