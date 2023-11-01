package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    @RepeatedTest(5)
    void createRandomNumber() {

        int randomNumber = RandomNumberGenerator.createRandomNumber();

        assertThat(randomNumber).isBetween(START_INCLUSIVE, END_INCLUSIVE);

    }
}