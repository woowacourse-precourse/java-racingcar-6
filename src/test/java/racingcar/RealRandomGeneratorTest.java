package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.model.RealRandomGenerator;

public class RealRandomGeneratorTest {

    RealRandomGenerator randomGenerator = new RealRandomGenerator();

    @RepeatedTest(100)
    public void 무작위_값_생성_검증() {

        // when
        int result = randomGenerator.pick();

        Assertions.assertTrue(result >= 0 && result <=9);
    }
}
