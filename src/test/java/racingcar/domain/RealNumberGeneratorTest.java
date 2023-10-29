package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class RealNumberGeneratorTest {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    @RepeatedTest(100)
    void 랜덤숫자_0부터_9_사이인지_확인() {
        NumberGenerator numberGenerator = new RealNumberGenerator();
        int randomNumber = numberGenerator.createRandomNumber();
        assertThat(randomNumber).isBetween(MIN_NUMBER, MAX_NUMBER);
    }
}
