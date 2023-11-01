package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    boolean isRandomNumberInRange = false;

    @RepeatedTest(1000)
    void randomNumberGenerate_범위_안의_값이_나오는지_테스트() {
        int randomNumber = randomNumberGenerator.randomNumberGenerate();
        if (randomNumber >= 0 && randomNumber < 10) isRandomNumberInRange = true;
        Assertions.assertThat(isRandomNumberInRange).isTrue();
    }
}