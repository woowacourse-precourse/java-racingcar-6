package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @Test
    public void 수_랜덤_생성에_성공한다() {
        for (int i = 0; i < 100; i++) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            assertTrue(randomNumber >= 0 && randomNumber <= 9);
        }
    }
}
