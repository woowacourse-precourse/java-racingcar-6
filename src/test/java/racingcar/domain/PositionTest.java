package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void createPosition_Successfully() {
        Position position = new Position(3);
        assertEquals(3, position.value());
    }

    @Test
    void createPosition_WithNegativeValue_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-1));
    }

    @Test
    void incrementPosition_Successfully() {
        Position position = new Position(1);
        Position incremented = position.increment();
        assertEquals(2, incremented.value());
    }

    @Test
    void comparePositions() {
        Position position1 = new Position(1);
        Position position2 = new Position(2);
        Position position3 = new Position(1);

        assertEquals(0, position1.compareTo(position3));
        assertEquals(-1, position1.compareTo(position2));
        assertEquals(1, position2.compareTo(position1));
    }
}
