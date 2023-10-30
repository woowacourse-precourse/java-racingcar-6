package racingcar.UtilTest;

import org.junit.jupiter.api.Test;
import racingcar.Util.RandomGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomGeneratorTest {

    @Test
    public void testGenerateRandomNumber() {
        int randomNumber = RandomGenerator.generateRandomNumber();

        assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }
}
