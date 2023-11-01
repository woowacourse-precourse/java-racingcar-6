package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {
    @Test
    @DisplayName("랜덤 값을 생성에 성공한다.")
    void getRandomNumberTest() {
        int number = RandomUtils.getRandomNumber();
        assertThat(number).isBetween(0, 9);
    }
}