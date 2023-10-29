package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarUtilTest {

    @Test
    @DisplayName("랜덤 숫자는 한자리 자연수여야 한다")
    void getRandomValueTest() {
        // when
        int randomValue = CarUtil.getRandomValue();
        // then
        Assertions.assertTrue(randomValue>0);
    }
}