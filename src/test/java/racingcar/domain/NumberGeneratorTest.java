package racingcar.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {
    @RepeatedTest(10)
    void generateRandomNumber_메서드는_0부터9까지_수_생성() {
        assertThat(NumberGenerator.generateRandomNumber()).isBetween(0, 9);
    }

    @Test
    void toInt_숫자_치환() {
        String input = "03";
        String input1 = "5";
        String input2 = "10";
        String input3 = "100";
        String input4 = "1a";
        String input5 = "pon1";

        assertThat(NumberGenerator.toInt(input)).isEqualTo(3);
        assertThat(NumberGenerator.toInt(input1)).isEqualTo(5);
        assertThat(NumberGenerator.toInt(input2)).isEqualTo(10);
        assertThat(NumberGenerator.toInt(input3)).isEqualTo(100);
        assertThatThrownBy(() -> NumberGenerator.toInt(input4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자만 입력 가능합니다.");
        assertThatThrownBy(() -> NumberGenerator.toInt(input5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자만 입력 가능합니다.");
    }
}