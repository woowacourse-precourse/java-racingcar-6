package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DistanceTest {
    @Test
    void equals_메소드_테스트() {
        Distance firstZero = Distance.zero();
        Distance first = firstZero.plusOne();
        Distance secondZero = Distance.zero();
        Distance second = secondZero.plusOne();
        assertEquals(first, second);
        assertEquals(second, first);
    }

    @Test
    void visualize_메소드_테스트() {
        Distance five = Distance.zero();
        for (int i = 0; i < 5; i++) {
            five = five.plusOne();
        }
        assertEquals(five.visualize(), "-----");
    }
}
