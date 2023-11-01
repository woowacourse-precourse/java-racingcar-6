package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RandomSingleNumberTest {
    private static final int MOVE_THRESHOLD = 4;
    private static final int NUM_UNDER_THRESHOLD = 3;
    private static final int NUM_UPPER_THRESHOLD = 5;
    @Test
    void isAtLest_메소드로_필드_number_값이_임계값_이상인지_판별() {
        RandomSingleNumber number1 = RandomSingleNumber.of(NUM_UNDER_THRESHOLD, NUM_UNDER_THRESHOLD);
        RandomSingleNumber number2 = RandomSingleNumber.of(NUM_UPPER_THRESHOLD, NUM_UPPER_THRESHOLD);

        assertFalse(number1.isAtLeast(MOVE_THRESHOLD));
        assertTrue(number2.isAtLeast(MOVE_THRESHOLD));
    }
}
