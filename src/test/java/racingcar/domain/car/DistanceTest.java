package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DistanceTest {
    @Test
    void equals_메소드_테스트() {
        Distance distance1 = new Distance(1);
        Distance distance2 = new Distance(1);
        assertEquals(distance1, distance2);
    }
}
