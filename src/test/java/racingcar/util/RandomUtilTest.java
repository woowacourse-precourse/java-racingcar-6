package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomUtilTest {

    @RepeatedTest(100)
    @DisplayName("범위안의 수를 임의의 수로 만드는지 테스트")
    void generateRandomValue() {
        // given
        int min = 0;
        int max = 9;

        // when
        int randomValue = RandomUtil.generateRandomValue(min, max);

        // then
        assertThat(randomValue).isBetween(0, 9);
    }

    @Test
    @DisplayName("실수로 큰 값을 첫 번째 파라미터로 넣은 경우")
    void generateRandomValue_MinBiggerThanMax() {
        // given
        int min = 5;
        int max = 3;

        // when
        int randomValue = RandomUtil.generateRandomValue(min, max);

        // then
        assertThat(randomValue).isBetween(max, min);
    }

    @Test
    @DisplayName("임의의 값 범위중 가장 작은값과 가장 큰 값이 같은 경우")
    void generateRandomValue_MinisEqualMax() {
        // given
        int min = 5;
        int max = 5;

        // when
        int randomValue = RandomUtil.generateRandomValue(min, max);

        // then
        assertThat(randomValue).isEqualTo(min);
    }


}
