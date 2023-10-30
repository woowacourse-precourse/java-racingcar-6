package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomUtilsTest {
    @Test
    void getRandomNumber_랜덤값_생성() {
        int number = RandomUtils.getRandomNumber();
        assertThat(number).isBetween(0, 9);
    }
}