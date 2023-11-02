package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    @Test
    void generate_메서드로_범위내의_임의의_수_생성() {
        int result = NumberGenerator.generate();

        assertThat(result).isBetween(0, 9);
    }
}