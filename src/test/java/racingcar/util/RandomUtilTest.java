package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomUtilTest {

    @Test
    void 랜덤_숫자_생성_범위_체크() {
        int startNumber = 1;
        int endNumber = 9;

        int randomNumber = RandomUtil.getRandomNumberRange(startNumber, endNumber);

        Assertions.assertThat(randomNumber >= 1 && randomNumber <= 9).isTrue();
    }
}
