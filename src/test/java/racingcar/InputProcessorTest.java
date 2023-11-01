package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

//GPT CODE

public class InputProcessorTest {
    private InputStream originalSystemIn;

    @BeforeEach
    public void setUp() {
        originalSystemIn = System.in;
    }

    @AfterEach
    public void restoreSystemIn() {
        System.setIn(originalSystemIn);
        InputProcessor.close();
    }

    @Test
    public void testReadLine() {
        String simulatedInput = "Hello, World\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String userInput = InputProcessor.readLine();
        assertEquals("Hello, World", userInput);
    }
}