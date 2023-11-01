package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

    @Test
    void 랜덤숫자생성_범위_확인() {
        RandomGenerator rg = new RandomGenerator();
        int number = rg.createRandomNumber();
        assertThat(number).isPositive().isLessThan(10);
    }
}