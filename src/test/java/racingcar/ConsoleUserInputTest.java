package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import racingcar.view.ConsoleUserInput;
import racingcar.view.RacingGameException;
import racingcar.view.UserInput;

public class ConsoleUserInputTest {

    @Test
    void testReadCarNamesInvalidInput() {
        UserInput userInput = new ConsoleUserInput();
        String input = " , , car2, car3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        try {
            userInput.readCarNames();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testReadNumberOfAttemptsValidInput() {
        UserInput userInput = new ConsoleUserInput();
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        try {
            int numberOfAttempts = userInput.readNumberOfAttempts();
            System.out.println("Number of Attempts: " + numberOfAttempts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void testReadNumberOfAttemptsInvalidInput() {
        UserInput userInput = new ConsoleUserInput();
        String input = "0";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(RacingGameException.class, userInput::readNumberOfAttempts);
    }
}
