package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setup() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    void 랜덤_숫자_생성() {
        Integer randomNumber = randomNumberGenerator.createRandomNumber();
        Assertions.assertNotNull(randomNumber);
    }
}
