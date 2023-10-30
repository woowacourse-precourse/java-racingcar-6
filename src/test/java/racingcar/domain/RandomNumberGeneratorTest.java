package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    void 무작위_수() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        assertThat(randomNumberGenerator.generateRandomNumber()).isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }

}