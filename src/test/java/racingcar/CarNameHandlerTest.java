package racingcar;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
            assertEquals(ErrorMessage.EMPTY_NAME_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void testHandleNameLengthExceedsMax() {
        try {
            carNameHandler.handle("Car1,Car2222,Car3");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorMessage.EXCEEDED_LENGTH_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void testHandleNameDuplication() {
        try {
            carNameHandler.handle("Car1,Car1,Car3");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorMessage.NAME_DUPLICATION_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void testHandleInvalidCarCount() {
        try {
            carNameHandler.handle("Car1");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(ErrorMessage.MIN_CAR_COUNT_EXCEPTION_MESSAGE, e.getMessage());
        }
    }
}