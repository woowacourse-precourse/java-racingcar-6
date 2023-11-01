package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.RaceSetting.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("무작위값은 0부터 9 사이이다.")
    void generate() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        int number = numberGenerator.generate();

        assertThat(number)
                .isGreaterThan(MIN_RANDOM_NUMBER.getValue())
                .isLessThan(MAX_RANDOM_NUMBER.getValue());
    }

}