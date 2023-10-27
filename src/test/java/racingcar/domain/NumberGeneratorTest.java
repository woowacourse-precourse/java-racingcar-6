package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    void createRandomNumber() {
        NumberGenerator numberGenerator = new NumberGenerator();
        int num = numberGenerator.createRandomNumber();
        Assertions.assertThat(num).isBetween(0, 9);
    }
}