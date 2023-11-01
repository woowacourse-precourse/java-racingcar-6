package racingcar;

import racingcar.controller.RoundCountHandler;
import racingcar.controller.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class RoundCountHandlerTest {
    private RoundCountHandler roundCountHandler;

    @BeforeEach
    public void setUp() {
        roundCountHandler = new RoundCountHandler();
    }

    @Test
    public void testHandleValidInput() {
        roundCountHandler.handle("5");
        assertEquals(5, roundCountHandler.getHandledResult());
    }

    @Test
    public void testHandleZeroInput() {
        try {
            roundCountHandler.handle("0");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorMessage.ZERO_ERROR_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void testHandleNonNumericInput() {
        try {
            roundCountHandler.handle("absy");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorMessage.NON_NUMERIC_MESSAGE, e.getMessage());
        }
    }
}
