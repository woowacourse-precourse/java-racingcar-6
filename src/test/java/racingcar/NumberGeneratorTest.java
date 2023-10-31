package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @DisplayName("RandomNumberGenerator 는 0 부터 9 사이의 숫자만 생성해야한다.")
    @Test
    void randomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int generatedNumber = randomNumberGenerator.generate();
        assertThat(generatedNumber).isBetween(0, 9);
    }
}