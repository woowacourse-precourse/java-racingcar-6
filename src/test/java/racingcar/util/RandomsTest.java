package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomsTest {

    @Test
    @DisplayName("0~9 까지의 숫자만 출력된다.")
    public void RandomsTest() {
        // when
        int random = Randoms.getNumber();
        // then
        assertThat(random).isBetween(0, 9);
    }
}