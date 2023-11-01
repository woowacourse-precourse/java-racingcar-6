package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    void generate_메서드로_범위내의_임의의_수_생성() {
        int result = numberGenerator.generate();

        assertThat(result).isBetween(0, 9);
    }

    @Test
    void judge_메서드로_기준점_이상의_수_이면_참_반환() {
        boolean result = numberGenerator.judge(7);

        assertThat(result).isTrue();
    }

    @Test
    void judge_메서드에_generate_메서드로_값_입력시_적합한_결과_반환() {
        int input = numberGenerator.generate();
        boolean result = numberGenerator.judge(input);

        if (input < 4) {
            assertThat(result).isFalse();
        }
        if (input >= 4) {
            assertThat(result).isTrue();
        }
    }
}