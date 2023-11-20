package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {
    @DisplayName("숫자 비교 기능 테스트")
    @Test
    void compareNumberTest() {
        NumberGenerator numberGenerator = new NumberGenerator();
        assertThat(numberGenerator.findMaxNumber(1,2)).isEqualTo(2);
    }
}