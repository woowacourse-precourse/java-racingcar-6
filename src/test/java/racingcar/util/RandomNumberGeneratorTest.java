package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    private static final int RANDOM_RANGE_START = 0;
    private static final int RANDOM_RANGE_END = 9;

    @Test
    @RepeatedTest(100)
    void 난수_생성_범위() {
        Assertions.assertThat(RandomNumberGenerator.generateRandomNumber())
                .isBetween(RANDOM_RANGE_START, RANDOM_RANGE_END);
    }
}