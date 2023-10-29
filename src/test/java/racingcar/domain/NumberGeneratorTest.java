package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    void randomNumber1() {
        NumberGenerator numberGenerator = new NumberGenerator();
        int result = numberGenerator.createRandomNumber();
        assertThat(result).isBetween(1, 9);
    }

    @Test
    void randomNumber2() {
        NumberGenerator numberGenerator = new NumberGenerator();
        int result = numberGenerator.createRandomNumber();
        assertThat(result).isBetween(1, 9);
    }

    @Test
    void randomNumber3() {
        NumberGenerator numberGenerator = new NumberGenerator();
        int result = numberGenerator.createRandomNumber();
        assertThat(result).isBetween(1, 9);
    }

}