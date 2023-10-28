package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class RealNumberGeneratorTest {

    @RepeatedTest(100)
    void 랜덤숫자_0부터_9_사이인지_확인() {
        NumberGenerator numberGenerator = new RealNumberGenerator();
        int randomNumber = numberGenerator.createRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }
}
