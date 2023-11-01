package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class UserInputTest {
    private UserInput userInput;

    @BeforeEach
    void setUp() {
        userInput = new UserInput();
    }

    @Test
    void getCarListTest() {
        try (MockedStatic<Console> mockedStatic = Mockito.mockStatic(Console.class)) {
            mockedStatic.when(Console::readLine).thenReturn("carA,carB,carC");

            List<String> result = userInput.getCarList();
            assertEquals(List.of("carA", "carB", "carC"), result);
        }
    }

    @Test
    void validCarTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            userInput.validCar("carABC");
        });
        assertDoesNotThrow(() -> {
            userInput.validCar("carA");
        });

    }

    @Test
    void getAttemptNumberTest() {
        try (MockedStatic<Console> mockedStatic = Mockito.mockStatic(Console.class)) {
            mockedStatic.when(Console::readLine).thenReturn("55");
            assertEquals(userInput.getAttemptNumber(), Integer.parseInt("55"));
        }
    }

    @Test
    void validNumberTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            userInput.validAttemptNumber("12w");
        });
        assertDoesNotThrow(() -> {
            userInput.validAttemptNumber("32");
        });
    }
}
