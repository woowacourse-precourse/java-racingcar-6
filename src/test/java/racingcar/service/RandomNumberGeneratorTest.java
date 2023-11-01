package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("올바른 범위의 랜덤한 숫자 생성")
    @Test
    void checkRandomNumberGenerate() {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        int t = 10;
        while (t-- > 0) {
            assertThat(numberGenerator.generate()).isBetween(0, 9);
        }
    }
}
