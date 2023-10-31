package racingcar.common.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    @Test
    void 거리_생성() {
        // Given
        int initialDistance = 0;

        // When
        Distance distance = Distance.of(initialDistance);

        // Then
        assertNotNull(distance);
        assertEquals(initialDistance, distance.getDistance());
    }

    @Test
    void 거리_증가() {
        // Given
        int initialDistance = 0;
        Distance distance = Distance.of(initialDistance);

        // When
        distance.increase();

        // Then
        assertEquals(initialDistance + 1, distance.getDistance());
    }

    @Test
    void 거리_비교() {
        // Given
        int initialDistance = 5;
        Distance distance = Distance.of(initialDistance);

        // When & Then
        assertTrue(distance.isEqual(5));
        assertFalse(distance.isEqual(4));
    }

    @Test
    void 거리_조회() {
        // Given
        int initialDistance = 3;
        Distance distance = Distance.of(initialDistance);

        // When & Then
        assertEquals(initialDistance, distance.getDistance());
    }
}
