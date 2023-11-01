package racingcar.utilTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import racingcar.util.RandomNumberGenerator;

public class RandomNumberGeneratorTest {
    private final int MIN_RANDOM_NUMBER = 1;
    private final int MAX_RANDOM_NUMBER = 9;
    @Test
    void testMakeRandomNumberInRange() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        int randomNumber = randomNumberGenerator.makeRandomNumber();

        assertThat(randomNumber).isBetween(MIN_RANDOM_NUMBER,MAX_RANDOM_NUMBER);
    }
}