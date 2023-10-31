package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @RepeatedTest(5)
    void createRandomNumber() {

        int randomNumber = randomNumberGenerator.createRandomNumber();

        Assertions.assertThat(randomNumber).isBetween(START_INCLUSIVE, END_INCLUSIVE);

    }
}