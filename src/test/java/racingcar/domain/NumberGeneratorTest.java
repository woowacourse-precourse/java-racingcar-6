package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {
    @Test
    void generateRandomNumber_메서드는_0부터9까지_수_생성() {
        for (int i = 0; i < 10; i++) {
            assertThat(NumberGenerator.generateRandomNumber()).isBetween(0, 9);
        }
    }
}