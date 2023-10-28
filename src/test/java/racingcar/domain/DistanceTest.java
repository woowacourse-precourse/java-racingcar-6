package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DistanceTest {

    @Test
    public void 초기값_확인() {
        Distance distance = new Distance();
        assertEquals(0, distance.getDistance());
    }

    @Test
    public void testMoveMethod() {
        Distance distance = new Distance();

        distance.move();
        assertEquals(1, distance.getDistance());

        distance.move();
        distance.move();
        assertEquals(3, distance.getDistance());
    }
}
