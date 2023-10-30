package racingcar.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {
    @RepeatedTest(10)
    void generateRandomNumber_메서드는_0부터9까지_수_생성() {
        assertThat(NumberGenerator.generateRandomNumber()).isBetween(0, 9);
    }
}