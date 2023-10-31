package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {

    @DisplayName("0~9 사이의 무작위 값 생성")
    @Test
    void createRandomNumber() {
        assertThat(NumberGenerator.createRandomNumber())
                .isGreaterThan(-1)
                .isLessThan(10);
    }
}