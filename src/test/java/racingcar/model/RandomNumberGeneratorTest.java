package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.util.Constants;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomNumberGeneratorTest {

    @Test
    void generate시_정수_0_9범위로_생성된다() {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int result = randomNumberGenerator.generate();
        assertThat(result).isBetween(Constants.RANDOM_NUM_START, Constants.RANDOM_NUM_END);
    }

}