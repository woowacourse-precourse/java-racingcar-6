package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    @Test
    void 랜덤_발생_숫자_범위가_0_9_사이_확인() {
        for (int i = 0; i < 100; i++) {
            int randomNumber = RandomNumberGenerator.pickRandomNumber();
            assertTrue(randomNumber >= MIN_RANDOM_NUMBER);
            assertTrue(randomNumber <= MAX_RANDOM_NUMBER);
        }
    }
}