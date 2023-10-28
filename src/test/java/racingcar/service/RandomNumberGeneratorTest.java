package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @DisplayName("0~9까지의 난수를 생성한다.")
    @Test
    @RepeatedTest(10)
    void generateRandomValue() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

            int actual = randomNumberGenerator.generateRandomNumber();
            assert (actual >= 0 && actual <= 9);
    }
}
