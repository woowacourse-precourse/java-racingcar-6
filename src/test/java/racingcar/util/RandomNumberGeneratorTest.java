package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator;

    @Test
    void createRandomNumber_0부터_9사이의_난수_생성() {
        randomNumberGenerator = new RandomNumberGenerator();
        assertTrue(randomNumberGenerator.createRandomNumber() >= 0);
        assertTrue(9 >= randomNumberGenerator.createRandomNumber());
    }
}