package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.constant.RaceSetting.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("무작위값은 0부터 9 사이이다.")
    void generate() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        int number = numberGenerator.generate();

        assertTrue(number >= MIN_RANDOM_NUMBER.getValue()
                && number <= MAX_RANDOM_NUMBER.getValue());
    }

}