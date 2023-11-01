package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import racingcar.controller.CarNameHandler;
import racingcar.controller.ErrorMessage;

public class CarNameHandlerTest {
    private CarNameHandler carNameHandler;

    @BeforeEach
    public void setup() {
        carNameHandler = new CarNameHandler();
    }

    @Test
    public void testHandleValidInput() {
        carNameHandler.handle("Car1,Car2,Car3");
        Iterator<String> carNames = carNameHandler.getHandledResult();

        assertTrue(carNames.hasNext());
        assertEquals("Car1", carNames.next());
        assertTrue(carNames.hasNext());
        assertEquals("Car2", carNames.next());
        assertTrue(carNames.hasNext());
        assertEquals("Car3", carNames.next());
        assertFalse(carNames.hasNext());
    }

    @Test
    public void testHandleEmptyName() {
        try {
            carNameHandler.handle("Car1,,Car3");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorMessage.EMPTY_NAME_ERROR, e.getMessage());
        }
    }

    @Test
    public void testHandleNameLengthExceedsMax() {
        try {
            carNameHandler.handle("Car1,Car2222,Car3");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorMessage.INVALID_LENGTH_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void testHandleNameDuplication() {
        try {
            carNameHandler.handle("Car1,Car1,Car3");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorMessage.CAR_NAME_DUPLICATION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void testHandleInvalidCarCount() {
        try {
            carNameHandler.handle("Car1");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorMessage.MIN_CAR_COUNT_ERROR_MESSAGE, e.getMessage());
        }
    }
}