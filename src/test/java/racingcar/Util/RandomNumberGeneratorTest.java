package racingcar.Util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    @Test
    public void testGetRandomNumber_랜덤_숫자_범위_확인() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        int randomValue = randomNumberGenerator.getRandomNumber();

        assertThat(randomValue).isBetween(0, 9);
    }
}