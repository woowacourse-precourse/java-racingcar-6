package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    void 주어진_범위_내의_랜덤으로_생성된_숫자를_반환한다() {

        int min = RandomNumberGenerator.MIN_RANDOM_INTEGER;
        int max = RandomNumberGenerator.MAX_RANDOM_INTEGER;

        // 테스트를 여러 번 실행하여 무작위 정수를 검증.
        for (int i = 0; i < 1000; i++) {
            Integer randomInt = randomNumberGenerator.getRandomInteger();
            Assertions.assertThat(randomInt).isNotNull();
            Assertions.assertThat(randomInt).isBetween(min, max);
        }
    }
}