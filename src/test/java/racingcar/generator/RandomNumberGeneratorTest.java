package racingcar.generator;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.enums.RacingConfig.*;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    void 생성된_랜덤_숫자는_범위_내의_숫자_중_하나이다() {
        // when
        int randomNumber = randomNumberGenerator.generateNumber();

        // then
        assertTrue(randomNumber >= RANDOM_NUMBER_MIN.getValue());
        assertTrue(randomNumber <= RANDOM_NUMBER_MAX.getValue());
    }
}