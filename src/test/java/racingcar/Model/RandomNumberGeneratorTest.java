package racingcar.Model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    static RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    void 랜덤_숫자_생성() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertTrue(randomNumberGenerator.getRandomNumberResult() == 4);
                },
                4
        );

    }

}