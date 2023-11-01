package study;

import org.junit.jupiter.api.Test;
import racingcar.config.GameRange;
import racingcar.util.RandomsWrapper;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomsWrapperTest {

    @Test
    void testRandomNumberInRange() {
        RandomsWrapper randomsWrapper = new RandomsWrapper();
        int randomNumber = randomsWrapper.pickNumberInRange();

        assertTrue(randomNumber >= GameRange.MIN_RANGE_VALUE.getValue() && randomNumber <= GameRange.MAX_RANGE_VALUE.getValue());

    }
}

