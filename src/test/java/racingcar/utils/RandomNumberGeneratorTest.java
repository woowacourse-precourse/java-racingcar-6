package racingcar.utils;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberGeneratorTest {

    @RepeatedTest(100)
    void generate_메서드는_0부터_9까지의_랜덤_숫자를_반환한다(){
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int generatedNumber = randomNumberGenerator.generate();
        assertTrue(generatedNumber >= 0 && generatedNumber <= 9);
    }
}
