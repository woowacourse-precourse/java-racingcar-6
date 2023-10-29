package domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RandomGenerator;

public class RandomGeneratorTest {
    private static int START_NUMBER_RANGE = 0;
    private static int END_NUMBER_RANGE = 9;

    @Test
    @DisplayName("0부터 9까지 숫자가 발생하는 지 확인")
    void 범위_숫자_확인() throws Exception {
        //given
        RandomGenerator randomGenerator = new RandomGenerator();

        //when, then
        for (int i = 0; i < 100; i++) {
            int randomNum = randomGenerator.generate();
            assertTrue(randomNum >= START_NUMBER_RANGE);
            assertTrue(randomNum <= END_NUMBER_RANGE);
        }
    }
}
