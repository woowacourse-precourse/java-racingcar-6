package racingcar;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomsTest {

    @Test
    void pickNumberInRange_ShouldGenerateRandomValueInGivenRange() {
        int min = 0;
        int max = 9;

        // 여러 번 테스트하여 무작위 값을 생성하고 범위 내에 있는지 확인
        for (int i = 0; i < 1000; i++) {
            int randomValue = Randoms.pickNumberInRange(min, max);
            assertThat(randomValue).isGreaterThanOrEqualTo(min);
            assertThat(randomValue).isLessThanOrEqualTo(max);
        }
    }
}
