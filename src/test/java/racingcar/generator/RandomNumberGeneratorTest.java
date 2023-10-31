package racingcar.generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.enums.RacingConfig.MAX_RANDOM_NUMBER;
import static racingcar.enums.RacingConfig.MIN_RANDOM_NUMBER;

class RandomNumberGeneratorTest {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    void 생성된_랜덤_숫자는_범위_내의_숫자_중_하나이다() {
        // when
        int randomNumber = randomNumberGenerator.generateNumber();

        // then
        assertTrue(randomNumber >= MIN_RANDOM_NUMBER.getValue());
        assertTrue(randomNumber <= MAX_RANDOM_NUMBER.getValue());
    }
}