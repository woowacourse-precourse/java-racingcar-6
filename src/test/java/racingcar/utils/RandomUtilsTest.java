package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomUtilsTest {
    @Test
    void 일정한_범위_내의_무작위_쑷자를_생성한다() {
        // given
        int min = 1;
        int max = 10;

        // when
        int actual = RandomUtils.generateRandomNumber();

        // then
        assertThat(actual).isBetween(min, max);
    }
}
