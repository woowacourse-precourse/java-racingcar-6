package racingcar.io;

import org.junit.jupiter.api.Test;
import racingcar.utils.provider.InputProvider;

import static org.junit.jupiter.api.Assertions.*;

public class InputManagerTest {
    OutputManager outputManager = new OutputManager();

    @Test
    public void testReadCarNameInput_ValidInput() {
        InputProvider validInputProvider = () -> "car1,car2,car3";
        InputManager inputManager = new InputManager(outputManager, validInputProvider);
        String input = inputManager.readCarNameInput();
        assertEquals("car1,car2,car3", input);
    }

    @Test
    public void testReadTryCountInput_ValidInput() {
        InputProvider validInputProvider = () -> "5";
        InputManager inputManager = new InputManager(outputManager, validInputProvider);
        String input = inputManager.readTryCountInput();
        assertEquals("5", input);
    }

    @Test
    public void testReadCarNameInput_InvalidWhitespace() {
        InputProvider invalidInputProvider = () -> "car1, car2,car3";
        InputManager inputManager = new InputManager(outputManager, invalidInputProvider);
        assertThrows(IllegalArgumentException.class, inputManager::readCarNameInput);
    }

    @Test
    public void testReadCarNameInput_InvalidNonAscii() {
        InputProvider invalidInputProvider = () -> "car1,가나다,car3";
        InputManager inputManager = new InputManager(outputManager, invalidInputProvider);
        assertThrows(IllegalArgumentException.class, inputManager::readCarNameInput);
    }

    @Test
    public void testReadCarNameInput_EmptyName() {
        InputProvider invalidInputProvider = () -> "car1,,car3";
        InputManager inputManager = new InputManager(outputManager, invalidInputProvider);
        assertThrows(IllegalArgumentException.class, inputManager::readCarNameInput);
    }

    @Test
    public void testReadCarNameInput_InvalidLength() {
        InputProvider invalidInputProvider = () -> "car123456,car2,car3";
        InputManager inputManager = new InputManager(outputManager, invalidInputProvider);
        assertThrows(IllegalArgumentException.class, inputManager::readCarNameInput);
    }

    @Test
    public void testReadCarNameInput_NonUniqueName() {
        InputProvider invalidInputProvider = () -> "car1,car1,car2";
        InputManager inputManager = new InputManager(outputManager, invalidInputProvider);
        assertThrows(IllegalArgumentException.class, inputManager::readCarNameInput);
    }

    @Test
    public void testReadTryCountInput_NonInteger() {
        InputProvider invalidInputProvider = () -> "five";
        InputManager inputManager = new InputManager(outputManager, invalidInputProvider);
        assertThrows(IllegalArgumentException.class, inputManager::readTryCountInput);
    }

    @Test
    public void testReadTryCountInput_OutOfRange() {
        InputProvider invalidInputProvider = () -> "-1";
        InputManager inputManager = new InputManager(outputManager, invalidInputProvider);
        assertThrows(IllegalArgumentException.class, inputManager::readTryCountInput);
    }
}
