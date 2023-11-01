package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.TestConstant;

class RandomUtilTest {
    @Test
    @DisplayName("0과 9 사이의 정수 생성 테스트")
    void createRandomNumberInRangeTest() {
        int rndNum = RandomUtil.createRandomNumberInRange(TestConstant.MIN_RANDOM_NUMBER,
                TestConstant.MAX_RANDOM_NUMBER);

        assertTrue(TestConstant.MIN_RANDOM_NUMBER <= rndNum && rndNum <= TestConstant.MAX_RANDOM_NUMBER);
    }
}