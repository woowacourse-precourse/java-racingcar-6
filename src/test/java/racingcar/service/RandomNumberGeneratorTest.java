package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @DisplayName("0~9까지의 난수를 생성한다.")
    @Test
    void generateRandomValue() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        for (int i = 0; i < 10; i++) {
            int actual = randomNumberGenerator.generateRandomNumber();
            assert (actual >= 0 && actual <= 9);
        }
    }
}
