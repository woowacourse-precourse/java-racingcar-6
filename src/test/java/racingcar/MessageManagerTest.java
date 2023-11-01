package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ResourceBundle;
import org.junit.jupiter.api.Test;

//GPT CODE
class MessageManagerTest {
    @Test
    public void testGetInputCarNameMessage() {
        // Redirect System.out to capture the printed message
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Assuming you have a ResourceBundle named "messages"
        ResourceBundle messages = ResourceBundle.getBundle("messages");

        // Call your method
        MessageManager.getInputCarNameMessage();

        // Capture the printed message
        String printedMessage = outputStream.toString().trim();

        // Restore System.out
        System.setOut(System.out);

        // Define the expected message from the ResourceBundle
        String expectedMessage = messages.getString("inputCarName.message");

        // Compare the expected message with the printed message
        assertEquals(expectedMessage, printedMessage);
    }
}