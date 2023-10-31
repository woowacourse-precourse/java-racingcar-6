package study;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void testValidCarName() {
        assertDoesNotThrow(() -> new Car("Valid"));
    }

    @Test
    void testInvalidCarName() {
        assertThrows(IllegalArgumentException.class, () -> new Car("ThisNameIsTooLong"));
        assertThrows(IllegalArgumentException.class, () -> new Car(""));
    }

}
