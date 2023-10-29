package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.RandomNumberGenerator;

public class RandomNumberGeneratorTest {

    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    void 랜덤_숫자는_0과_9사이이다() {
        Assertions.assertThat(randomNumberGenerator.generateRandomNumber()).isBetween(0,9);
    }
}
