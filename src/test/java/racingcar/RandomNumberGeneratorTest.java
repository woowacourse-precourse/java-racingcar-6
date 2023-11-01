package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    @Test
    void 랜덤_숫자_범위_검증() {
        int randomNumber = RandomNumberGenerator.createRandomNumber();
        assertThat(randomNumber).isBetween(MIN_NUMBER, MAX_NUMBER);
    }
}