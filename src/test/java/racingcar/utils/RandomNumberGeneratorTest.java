package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("무작위 수는 설정한 최소값과 최대값 사이의 값이어야 한다.")
    void pickNumberInRange() {
        int count = 100;

        while(count-- > 0) {
            Assertions.assertThat(RandomNumberGenerator.pickNumberInRange()).isBetween(0, 9);
        }
    }
}
