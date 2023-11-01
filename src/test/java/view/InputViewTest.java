package view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import util.RandomNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class InputViewTest {
    private static MockedStatic<Console> console;

    @BeforeAll
    public static void beforeClass() {
        console = mockStatic(Console.class);
    }

    @AfterAll
    public static void afterAll() {
        console.close();
    }

    @Test
    public void 차이름_제대로_입력되었는지_검증() {
        when(Console.readLine()).thenReturn("I,love,you");

        String carsName = InputView.inputCarsName();

        assertEquals("I,love,you", carsName);
    }

    @Test
    public void 시도횟수_제대로_입력되었는지_검증() {
        when(Console.readLine()).thenReturn("5");

        String attemptNumber = InputView.inputAttemptNumber();

        assertEquals("5", attemptNumber);
    }
}

