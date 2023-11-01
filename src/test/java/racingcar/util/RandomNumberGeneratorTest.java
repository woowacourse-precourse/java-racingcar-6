package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.constant.Constant.RANDOM_MAX_RANGE;
import static racingcar.constant.Constant.RANDOM_MIN_RANGE;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    private static final int ITERATE_NUMBER = 1000;

    @Test
    @DisplayName("랜덤_정수_반복_확인")
    void generate() {
        assertTrue(IntStream.range(0, ITERATE_NUMBER)
                .mapToObj(i -> RandomNumberGenerator.generate())
                .allMatch(result -> result >= RANDOM_MIN_RANGE && result <= RANDOM_MAX_RANGE));

    }
}