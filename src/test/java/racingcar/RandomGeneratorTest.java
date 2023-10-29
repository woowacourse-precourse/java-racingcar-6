package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.model.RandomGenerator;

public class RandomGeneratorTest {

    @RepeatedTest(100)
    public void 무작위_값_생성_검증() {

        // when
        int result = RandomGenerator.pick();

        Assertions.assertTrue(result >= 0 && result <=9);
    }
}
