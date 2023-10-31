package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DistanceTest {

    @Test
    public void testInitialValue() {
        Distance distance = new Distance();

        int expectedDistance = 0;
        int actualDistance = distance.getDistance();

        assertEquals(expectedDistance, actualDistance);
    }

    @Test
    public void testMoveMethod() {
        Distance distance = new Distance();

        distance.move();
        distance.move();
        distance.move();

        int expectedDistance = 3;
        int actualDistance = distance.getDistance();

        assertEquals(expectedDistance, actualDistance);
    }
}
