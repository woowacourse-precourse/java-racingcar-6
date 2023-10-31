package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.RandomGenerator;

class RandomGeneratorTest {
    @Test
    public void 랜덤_값() {
        // given
        int min = 0;
        int max = 10;

        // when
        int number = RandomGenerator.generateNumber(min, max);

        // then
        assertThat(number).isGreaterThanOrEqualTo(min).isLessThan(max);
    }

}