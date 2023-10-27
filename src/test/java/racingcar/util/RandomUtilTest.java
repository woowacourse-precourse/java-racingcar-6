package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.Constant;

class RandomUtilTest {
    @Test
    @DisplayName("0과 9 사이의 정수 생성 테스트")
    void createRandomNumberInRangeTest() {
        int rndNum = RandomUtil.createRandomNumberInRange(Constant.MIN_RANDOM_NUMBER, Constant.MAX_RANDOM_NUMBER);

        assertTrue(Constant.MIN_RANDOM_NUMBER <= rndNum && rndNum <= Constant.MAX_RANDOM_NUMBER);
    }
}