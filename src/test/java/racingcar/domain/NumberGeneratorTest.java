package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    @DisplayName("랜덤_숫자_범위_테스트")
    void createRandomNumber() {
        assertThat(NumberGenerator.createRandomNumber()).isBetween(0, 9);
    }
}
