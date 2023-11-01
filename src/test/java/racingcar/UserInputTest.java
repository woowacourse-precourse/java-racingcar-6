package racingcar;

import camp.nextstep.edu.missionutils.Console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    private UserInput userInput;

    @BeforeEach
    void setUp() {
        userInput = new UserInput();
    }

    @Test
    void testCarNameValidInput() {
        try (MockedStatic<Console> mockedConsole = Mockito.mockStatic(Console.class)) {
            mockedConsole.when(Console::readLine).thenReturn("abc,def,ghi,jklm,nopqr");
            assertDoesNotThrow(() -> userInput.carName());
        }
    }

    @Test
    void testCarNameInvalidInput() {
        try (MockedStatic<Console> mockedConsole = Mockito.mockStatic(Console.class)) {
            mockedConsole.when(Console::readLine).thenReturn("Car123,Bc-de,VeryLongCarName,, ");
            assertThrows(IllegalArgumentException.class, () -> userInput.carName());
        }
    }

    @Test
    void testAttemptsNumberValidInput() {
        try (MockedStatic<Console> mockedConsole = Mockito.mockStatic(Console.class)) {
            mockedConsole.when(Console::readLine).thenReturn("5");
            assertEquals(5, userInput.attemptsNumber());
        }
    }

    @Test
    void testAttemptsNumberInvalidInput() {
        try (MockedStatic<Console> mockedConsole = Mockito.mockStatic(Console.class)) {
            mockedConsole.when(Console::readLine).thenReturn("-1");
            assertThrows(IllegalArgumentException.class, () -> userInput.attemptsNumber());
        }
    }
}
