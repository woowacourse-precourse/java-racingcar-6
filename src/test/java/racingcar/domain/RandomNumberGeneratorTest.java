package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    @Test
    void 랜덤_발생_숫자_범위가_0_9_사이_확인() {
        assertThat(RandomNumberGenerator.pickRandomNumber())
                .isBetween(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}